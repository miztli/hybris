ACC.approval = {
    _autoload: [
        "bindToModalActionButton",
        "bindToOrderApprovalDecisionButtons",
        "bindToModalCancelButton"
    ],

    bindToModalActionButton : function() {
        $(document).on('click', '.approverDecisionButton', function() {
            var form = ACC.approval.currentForm;
            form.find('#approverSelectedDecision').attr("value", $(this).data('decision'));
            ACC.approval.isDecisionMade = true;
            ACC.colorbox.close();
        });
    },

    bindToModalCancelButton : function() {
        $(document).on('click', '.cancelOrderApprovalCommentButton',
            function(e) {
                e.preventDefault();
                ACC.colorbox.close();
            }
        );
    },

    bindToOrderApprovalDecisionButtons : function() {
        ACC.approval.bindToOrderApprovalDecisionButton('.approverDecisionApprovalButton', '.orderApprovalApproveCommentModal');
        ACC.approval.bindToOrderApprovalDecisionButton('.approverDecisionRejectButton', '.orderApprovalRejectCommentModal');
    },

    bindToOrderApprovalDecisionButton : function(decisionButtonSelector, popupModalSelector) {
        $(document).on('click', decisionButtonSelector, function(e) {
            e.preventDefault();
            var form = $(this).closest("form");
            var titleHtml = $(this).html();
            var quoteCommentModal = form.find(popupModalSelector);
            ACC.approval.currentForm = form;

            form.find('textarea').val('');
            ACC.approval.isDecisionTaken = false;

            ACC.colorbox.open(titleHtml, {
                href : quoteCommentModal,
                inline : true,
                width : "620px",
                onClosed: function() {
                    if (ACC.approval.isDecisionMade) {
                        form.submit();
                    }
                }
            });
        });
    }

};
