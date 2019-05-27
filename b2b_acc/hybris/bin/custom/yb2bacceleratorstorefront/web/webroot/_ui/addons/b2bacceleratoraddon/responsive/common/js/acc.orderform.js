var ACC = ACC || {}; // make sure ACC is available

if ($("#orderFormContainer").length > 0) {
    ACC.orderform = {
        _autoload: [
            "bindAll"
        ],

        $selectedProductIdsContainer: $("#js-selected-product-ids"),
        $productIdsInput: $("#js-product-ids"),
        $enableProductIdsCheckBox: $("#js-enable-product-ids"),
        $productIdTagBoxTemplate: $("#product-id-tag-box-template"),
        $removeProductIdButton: $(".js-remove-product-id"),
        $advSearchButton: $(".adv_search_button"),
        $orderFormToggle: $(".js-show-order-form-grid-wrapper"),
        $searchCurrentLabel: $(".searchInput label"),
        $createOrderFormButton: $(".js-create-order-form-button"),
        $createOrderFormCheckbox: $(".js-checkbox-sku-id, .js-checkbox-base-product"),
        $baseProductCheckBox: $(".js-checkbox-base-product"),
        $skuIDCheckbox: $(".js-checkbox-sku-id"),
        $skuQuantityOrderInput: $(".sku-quantity"),
        $addToCartBtn: $('#js-add-to-cart-order-form-btn-top, #js-add-to-cart-order-form-btn-bottom'),
        $orderForm:$("#isCreateOrderForm"),
        $userQtyInputSelection: $("input[data-product-selection]"),
        $totalPrice : $('.js-total-price'),
        $totalItemsCount : $('.js-total-items-count > span'),
        $totalPriceValue: $('.js-total-price-value'),
        $advancedSearchForm: $('#advancedSearchForm'),

        /*
         * Register all the event handlers.
         */
        bindAll: function () {
            ACC.orderform.bindToToggleProductIds(ACC.orderform.$enableProductIdsCheckBox);
            ACC.orderform.bindToRemoveProductId(ACC.orderform.$removeProductIdButton);
            ACC.orderform.bindToAdvSearchButton(ACC.orderform.$advSearchButton);
            ACC.orderform.bindOrderFormToggle(ACC.orderform.$orderFormToggle);
            ACC.orderform.bindToCreateOrderFormButton(ACC.orderform.$createOrderFormButton);
            ACC.orderform.bindToBaseProductCheckBox(ACC.orderform.$baseProductCheckBox);
            ACC.orderform.bindToSkuIDCheckBox(ACC.orderform.$skuIDCheckbox);
            ACC.orderform.bindAddToCartClick(ACC.orderform.$addToCartBtn);

            if (ACC.orderform.$enableProductIdsCheckBox.prop("checked")) {
                ACC.orderform.replaceSearchLabel(true);
                ACC.orderform.appendProductIdsForSearch();
            }

            if ($("#search-create-order-form").prop("checked")) {
                ACC.orderform.makeUserSelectionAfterPagination();
                ACC.orderform.setStateOrderFormButton();
            } else {
                ACC.orderform.fillQuantityValueForPagination(ACC.orderform.$userQtyInputSelection);
            }

            ACC.orderform.$advancedSearchForm.find("input[name='CSRFToken']").remove();
        },

        bindOrderFormToggle: function(orderFormToggle) {
            orderFormToggle.click(function (event) {
                var $this = $(this);
                $(this).toggleClass('open');
                var orderFormGridWrapper = $(this).parents('.js-item-list-item').next('.js-order-form-grid-wrapper');
                orderFormGridWrapper.slideToggle("slow", function() {
                    if(!$this.data('calc')) {
                        var scrollingContent = orderFormGridWrapper.children('#cartOrderGridForm').addClass('visible');
                        ACC.productorderform.coreTableScrollActions(scrollingContent);
                        $this.data('calc',true);
                    }
                });
            });
        },

        bindToAdvSearchButton: function (advSearchButton) {
            advSearchButton.click(function (event) {
                if (ACC.orderform.$enableProductIdsCheckBox.prop("checked")) {
                    //Append the new product id's to search in sku only mode!
                    if (ACC.orderform.$productIdsInput.val() != "") {
                        ACC.orderform.appendProductIdsForSearch();
                    }
                    ACC.orderform.$productIdsInput.val(ACC.orderform.getProductsIdsFromSessionStorage());
                }
                ACC.orderform.stripOutInvalidChars();
                if (ACC.orderform.$orderForm.val()) {
                    sessionStorage.clear();
                } else {
                    ACC.orderform.cleanupQtyInputFromSessionStorage();
                }
            });
        },

        bindToCreateOrderFormButton: function (createOrderFormButton) {
            createOrderFormButton.click(function (event) {
                ACC.orderform.stripOutInvalidChars();
                ACC.orderform.$productIdsInput.val(ACC.orderform.getProductsIdsFromSessionStorage());
                ACC.orderform.$orderForm.val(true);
                sessionStorage.removeItem("checkedProducts");
                ACC.orderform.$selectedProductIdsContainer.empty();
                ACC.orderform.$enableProductIdsCheckBox.attr("checked", false);
                ACC.orderform.$advSearchButton.click();
            });
        },

        bindToBaseProductCheckBox: function (baseProductCheckBox) {
            baseProductCheckBox.click(function (event) {
                var baseProduct = this;
                $(ACC.orderform.$skuIDCheckbox).each(function () {
                    if ($(this).attr("base-product-code") && $(this).attr("base-product-code") == baseProduct.value) {
                        $(this).prop("checked", baseProduct.checked);
                        ACC.orderform.addProductIdsToSessionStorage(this);
                    }
                })
            });
        },

        bindToSkuIDCheckBox: function (skuIDCheckbox) {
            skuIDCheckbox.click(function (event) {
                ACC.orderform.addProductIdsToSessionStorage(this);
            });
        },


        addToSkuQtyInput: function (_this) {
            // if there are no items to add, disable addToCartBtn, otherwise, enable it
            if (ACC.orderform.$totalItemsCount.length != 0 && ACC.orderform.$totalItemsCount.text() == 0) {
                ACC.orderform.$addToCartBtn.attr('disabled', 'disabled');
            } else {
                ACC.orderform.$addToCartBtn.removeAttr('disabled');
            }
            var qtyInputs = ACC.orderform.fetchOrPopulateSessionStorageObj("qtyInputs");
            var qtyInputJson = JSON.parse($(_this).attr("data-product-selection"));
            var filteredObjects = ACC.orderform.filterMatchingQtyInputs(qtyInputs, qtyInputJson);
            for (var i = 0; i < filteredObjects.length; i++) {
                qtyInputs.splice(qtyInputs.indexOf(filteredObjects[i]), 1);
            }
            qtyInputJson['qty'] = _this.value;
            qtyInputs.push(qtyInputJson);
            sessionStorage.setItem("qtyInputs", JSON.stringify(qtyInputs));

            ACC.orderform.setTotalItemPrice($(_this), _this.value, $(_this).siblings('.price').data('variant-price'));
        },

        setStateOrderFormButton: function () {
            ACC.orderform.$createOrderFormButton.attr('disabled', 'disabled');
            var checkedProducts = ACC.orderform.getProductsIdsFromSessionStorage();

            if(checkedProducts.length > 0){
                ACC.orderform.$createOrderFormButton.removeAttr("disabled");
            }
            else {
                ACC.orderform.$createOrderFormButton.attr('disabled', 'disabled');
            }
        },

        addProductIdsToSessionStorage: function (checkbox) {
            var clickedProductIds = JSON.parse(sessionStorage.getItem("checkedProducts"));
            if (clickedProductIds == null || clickedProductIds == undefined) {
                sessionStorage.setItem("checkedProducts", JSON.stringify([]))
                clickedProductIds = new Array();
            }

            var ifProductExist = clickedProductIds.indexOf(checkbox.value);

            if (checkbox.checked) {
                if (ifProductExist == -1)
                    clickedProductIds.push(checkbox.value);
            } else {
                if (ifProductExist != -1)
                    clickedProductIds.splice(ifProductExist, 1);
            }
            sessionStorage.setItem("checkedProducts", JSON.stringify(clickedProductIds));
            console.log(sessionStorage.getItem("checkedProducts"));
            ACC.orderform.setStateOrderFormButton();
        },

        fetchOrPopulateSessionStorageObj: function (item) {
            var storageObj = JSON.parse(sessionStorage.getItem(item));
            if (storageObj == null || storageObj == undefined) {
                sessionStorage.setItem(item, JSON.stringify([]))
                storageObj = new Array();
            }
            return storageObj
        },

        makeUserSelectionAfterPagination: function () {
            var clickedProductIds = JSON.parse(sessionStorage.getItem("checkedProducts"));
            if (clickedProductIds != null) {
                $(ACC.orderform.$skuIDCheckbox).each(function () {
                    if (clickedProductIds.indexOf(this.value) != -1)
                        $(this).prop("checked", true);
                })
            }
        },

        fillQuantityValueForPagination: function (userQtyInputSelection) {
            var qtyInputs = JSON.parse(sessionStorage.getItem("qtyInputs"));
            var prevParentId, prevVariantLoop, parentTable = {};
            if (qtyInputs != null && qtyInputs.length > 0) {
                userQtyInputSelection.each(function (obj) {
                    var filteredObjects = ACC.orderform.filterMatchingQtyInputs(qtyInputs, JSON.parse($(this).attr('data-product-selection')));
                    if (filteredObjects != null && filteredObjects.length > 0) {
                        var qty = filteredObjects[0].qty;
                        var resetSummary = false;
                        $(this).attr('value', qty);
                        if (this.hasAttribute('data-variant-id')) {

                            if(prevVariantLoop === $(this).parents('table').data('variant-loop')){
                                resetSummary = true;
                            }

                            ACC.productorderform.calculateVariantTotal($(this), qty);
                            if(prevParentId === $(this).data('parent-id') && prevVariantLoop === $(this).parents('table').data('variant-loop')){
                                ACC.productorderform.updateSelectedVariantGridTotal(this,0,false, resetSummary);
                            }
                            else {
                                ACC.productorderform.updateSelectedVariantGridTotal(this,0,true, resetSummary);
                            }
                            prevParentId = $(this).data('parent-id');
                            parentTable = $(this).parents('table');
                            prevVariantLoop = parentTable.data('variant-loop');
                        }
                    }
                });
                ACC.orderform.$addToCartBtn.removeAttr("disabled");
            }
            ACC.orderform.resetPriceCounters();
        },

        getProductsIdsFromSessionStorage: function () {
            var clickedProductIds = ACC.orderform.fetchOrPopulateSessionStorageObj("checkedProducts");
            if (clickedProductIds != null && clickedProductIds != "") {
                return clickedProductIds.join(",");
            }
            return [];
        },

        removeProductIdFromSessionStorage: function (productId) {
            var clickedProductIds = JSON.parse(sessionStorage.getItem("checkedProducts"));
            var ifProductExist = clickedProductIds.indexOf(productId);
            if (ifProductExist != -1) {
                clickedProductIds.splice(ifProductExist, 1);
            }
            sessionStorage.setItem("checkedProducts", JSON.stringify(clickedProductIds));
        },

        // Add product ids search enable checkbox handler
        bindToToggleProductIds: function (addProductIdsCheckBox) {
            addProductIdsCheckBox.on("change", function (event) {
                var checked = $(this).prop("checked");
                ACC.orderform.replaceSearchLabel(checked);
                // move the added product id tags back into the input
                var joinedProductIds = $.map(
                    ACC.orderform.$selectedProductIdsContainer.find(".product-id-tag-box .product-id"),
                    function (index) {
                        return $(index).text()
                    }
                ).join(", ");
                if (joinedProductIds !== "") {
                    ACC.orderform.$productIdsInput.val(joinedProductIds);
                }
                // clear product id tags
                ACC.orderform.$selectedProductIdsContainer.empty();
            });
        },

        // Add product id event handler
        appendProductIdsForSearch: function () {
            ACC.orderform.stripOutInvalidChars();
            var productIds = ACC.orderform.$productIdsInput.val().split(",");
            //  clean product ids
            productIds = $.map(productIds, function (productId, index) {
                return ($.trim(productId));
            });
            productIds = $.unique(productIds);
            var presentProductIds = ACC.orderform.fetchOrPopulateSessionStorageObj("checkedProducts");

            // create the tags by using a template
            $.each(productIds, function (index, productId) {
                var $existingProductId = ACC.orderform.$selectedProductIdsContainer.find("#product-id-" + productId);
                if (productId !== '' && $existingProductId.length == 0) {
                    // Render the product id tag boxes using the template
                    ACC.orderform.$productIdTagBoxTemplate
                        .tmpl({productId: productId, index: index})
                        .appendTo(ACC.orderform.$selectedProductIdsContainer);
                }
                if (presentProductIds.indexOf(productId) == -1) {
                    presentProductIds.push(productId);
                }
            });
            sessionStorage.setItem("checkedProducts", JSON.stringify(presentProductIds));
            // clear the input field
            ACC.orderform.$productIdsInput.val('');
            ACC.orderform.$productIdsInput.focus();
        },


        bindAddToCartClick: function (addToCartBtn) {
            addToCartBtn.click(function () {
                $.ajax({
                    url: ACC.productorderform.$addToCartOrderForm.attr("action"),
                    type: 'POST',
                    dataType: 'json',
                    contentType: 'application/json',
                    data: ACC.orderform.getJSONDataForAddToCart(),
                    async: false,
                    success: function (response) {
                        $(window).off('beforeunload', ACC.productorderform.beforeUnloadHandler);
                        ACC.product.displayAddToCartPopup(response);
                        ACC.orderform.cleanUserQtySelection(ACC.orderform.$userQtyInputSelection);
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        // log the error to the console
                        console.log("The following error occured: " + textStatus, errorThrown);
                    }
                });
            });
        },

        getJSONDataForAddToCart: function () {
            var qtyInputs = ACC.orderform.fetchOrPopulateSessionStorageObj("qtyInputs");
            var skusAsJSON = [];
            for (var i = 0; i < qtyInputs.length; i++) {
                if (parseInt(qtyInputs[i].qty) > 0) {
                    skusAsJSON.push({"product": {"code": qtyInputs[i].product}, "quantity": qtyInputs[i].qty});
                }
            }
            return JSON.stringify({"cartEntries": skusAsJSON});
        },


        bindToRemoveProductId: function (removeProductIdButton) {
            ACC.orderform.$selectedProductIdsContainer.on("click", removeProductIdButton, function (event) {
                event.preventDefault();
                var valueToRemove = $(event.target).parents('.js-remove-product-id');
                ACC.orderform.removeProductIdFromSessionStorage($(valueToRemove).children('.product-id').text());
                $(valueToRemove).remove();

                ACC.orderform.$selectedProductIdsContainer.empty();
                ACC.orderform.$enableProductIdsCheckBox.attr("checked", true);
                ACC.orderform.$productIdsInput.val(ACC.orderform.getProductsIdsFromSessionStorage());
                ACC.orderform.$advSearchButton.click();
            });
        },

        cleanUserQtySelection: function (userQtyInputSelection) {
            var qtyInputs = ACC.orderform.fetchOrPopulateSessionStorageObj("qtyInputs");
            if (qtyInputs != null && qtyInputs.length > 0) {
                userQtyInputSelection.each(function () {
                    $(this).prop('value', 0);
                    ACC.orderform.$addToCartBtn.attr('disabled', 'disabled');
                    ACC.orderform.setTotalItemPrice($(this), 0, 0);

                })
            }
            ACC.productorderform.cleanValues();
            ACC.productorderform.resetSelectedVariant();
            ACC.orderform.$totalPrice.html(ACC.productorderform.formatTotalsCurrency('0.00'));
            ACC.orderform.$totalItemsCount.text('0');
            ACC.orderform.$totalPriceValue.val(0);
            ACC.orderform.cleanupQtyInputFromSessionStorage();
        },

        replaceSearchLabel: function (productIdsChecked) {
        	var currentLabelHtml = ACC.orderform.$searchCurrentLabel.html();
        	var searchByIdsLabelHtml = ACC.common.encodeHtml($("#searchByIdsLabel").val());
        	var searchByKeywordLabelHtml  = ACC.common.encodeHtml($("#searchByKeywordLabel").val());
        	 
        	if (productIdsChecked) {
        		currentLabelHtml = currentLabelHtml.replace(searchByKeywordLabelHtml, searchByIdsLabelHtml);
        	} else {
        		currentLabelHtml = currentLabelHtml.replace(searchByIdsLabelHtml, searchByKeywordLabelHtml);
        	}
        	ACC.orderform.$searchCurrentLabel.html(currentLabelHtml);
        },

        stripOutInvalidChars: function () {
            ACC.orderform.$productIdsInput.val(ACC.orderform.$productIdsInput.val().replace(/[^a-z0-9 ,.\-_]/ig, ''));
        },

        cleanupQtyInputFromSessionStorage: function () {
            sessionStorage.removeItem("qtyInputs");
            sessionStorage.removeItem("totalPrice");
            sessionStorage.removeItem("totalPriceVal");
            sessionStorage.removeItem("totalItems");
        },

        resetPriceCounters: function () {
            ACC.orderform.$totalItemsCount.text(sessionStorage.totalItems);
            if (sessionStorage.totalPrice !== undefined) {
            	ACC.orderform.$totalPrice.html((ACC.sanitizer.sanitize(sessionStorage.totalPrice)));
            } else {
            	ACC.orderform.$totalPrice.html(ACC.productorderform.formatTotalsCurrency('0.00'));
            }
            ACC.orderform.$totalPriceValue.val(sessionStorage.totalPriceVal || 0);

            //sub-total
            ACC.orderform.fillTotalItemPrice();
        },

        setTotalItemPrice: function (item, quantity, price) {
            if(!item.data('variant-id')) {
                var htmlContent = (quantity > 0) ? ACC.productorderform.formatTotalsCurrency(price * quantity) : '';
                item.parent().next('.item-total').html(htmlContent);
            }
        },

        fillTotalItemPrice: function () {
            if (sessionStorage.qtyInputs !== undefined){
                var qtyInputsJson = JSON.parse(sessionStorage.qtyInputs);
                var $product = {};

                for (var i = 0; i < qtyInputsJson.length; i++) {
                    if (qtyInputsJson[i].qty > 0) {
                        $product = $('.' + qtyInputsJson[i].product);
                        var totalPrice = ACC.productorderform.formatTotalsCurrency($product.siblings('.price').data('variant-price') *  qtyInputsJson[i].qty);
                        $product.parent().siblings('.item-total').html(totalPrice);
                    }
                }
            }
        },

        filterMatchingQtyInputs: function (qtyInputs, dataValueObj) {
            var filteredObjects = $.grep(qtyInputs, function (obj) {
                return dataValueObj.product == obj.product;
            });
            return filteredObjects;
        }
    };
}

