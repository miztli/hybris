//
//  stylesheet.h
// [y] hybris Platform
//
// Copyright (c) 2000-2015 hybris AG
// All rights reserved.
//
// This software is the confidential and proprietary information of hybris
// ("Confidential Information"). You shall not disclose such Confidential
// Information and shall use it only in accordance with the terms of the
// license agreement you entered into with hybris.
//

#ifndef b2bios_stylesheet_h
#define b2bios_stylesheet_h

#define APP_NAME @"yB2B"

#define HEXColor(a) [UIColor colorWithHexString:a]

//generic colors definition
#pragma mark generic colors definition

#define hybris_white                    HEXColor(@"#ffffff")
#define hybris_blue                     HEXColor(@"#0054ae")
#define hybris_disable_blue             HEXColor(@"#6b97cb")
#define hybris_yellow                   HEXColor(@"#fad712")
#define hybris_red                      HEXColor(@"#e60000")
#define hybris_gray                     HEXColor(@"#d3d6db")
#define hybris_light_gray               HEXColor(@"#f0f0f0")
#define hybris_medium_gray              HEXColor(@"#b8bec8")
#define hybris_dark_gray                HEXColor(@"#313949")
#define hybris_black                    HEXColor(@"#000000")
#define hybris_green                    HEXColor(@"#009933")
#define hybris_clear                    [UIColor clearColor]

//default styling
#pragma mark default styling

#define button_default_background   hybris_yellow
#define button_hilighted_background hybris_yellow
#define button_disabled_background  hybris_disable_blue
#define button_selected_background  hybris_red

#define drop_down_button_default_background   hybris_white
#define drop_down_button_hilighted_background hybris_yellow
#define drop_down_button_disabled_background  hybris_light_gray
#define drop_down_button_selected_background  hybris_blue

#define button_default_text         hybris_blue

#define drop_down_button_default_text         hybris_black
#define drop_down_button_disabled_text        hybris_dark_gray

//menu
#define menu_text_default            hybris_white
#define menu_background_default      HEXColor(@"#283141")
#define menu_background_selected     HEXColor(@"#161b23")

//login
#pragma mark login

#define background_gradient_start   HEXColor(@"#013b7f")
#define background_gradient_end     HEXColor(@"#1c569a")
#define login_field_background      HEXColor(@"#316baf")
#define login_field_text            hybris_white


//catalog
#define catalog_toolbar_background      hybris_medium_gray
#define catalog_grid_cell_background    hybris_white
#define catalog_grid_background         hybris_light_gray
#define catalog_table_separator         hybris_gray

//cart
#define cart_background             hybris_light_gray
#define cart_title                  hybris_blue
#define cart_default_label          hybris_black
#define cart_savings_label          hybris_green

#define cart_table_header_background    hybris_gray
#define cart_table_action_background    hybris_light_gray
#define cart_table_background           hybris_white
#define cart_table_cell_background      cart_table_background
#define cart_table_footer_background    hybris_light_gray

#define cart_cell_product_name_font     [UIFont fontWithName:@"HelveticaNeue" size:16.f]
#define cart_cell_price_font            [UIFont fontWithName:@"HelveticaNeue" size:13.f]
#define cart_cell_total_price_font      [UIFont fontWithName:@"HelveticaNeue" size:16.f]
#define cart_cell_promotion_font        [UIFont fontWithName:@"HelveticaNeue" size:13.f]

#define cart_cell_promotion_text        hybris_green

//orders history
#define orders_history_title            hybris_blue

#define orders_history_cell_background_even     hybris_light_gray
#define orders_history_cell_background_odd      hybris_white
#define orders_history_cell_border              hybris_gray

#define orders_history_cell_font_text           [UIFont fontWithName:@"HelveticaNeue" size:18.f]
#define orders_history_cell_text                [UIColor darkTextColor]

#define orders_history_buttons                      hybris_white
#define orders_history_buttons_hilighted            hybris_blue
#define orders_history_buttons_background           hybris_medium_gray
#define orders_history_buttons_background_selected  hybris_dark_gray
#define orders_history_buttons_background_hilighted hybris_yellow

#define orders_history_filter_button                hybris_blue
#define orders_history_filter_button_hilighted      hybris_yellow
#define orders_history_filter_button_background     hybris_clear


#define orders_history_cell_font_buttons        [UIFont fontWithName:@"HelveticaNeue" size:16.f]

//store locator
#define store_locator_pin_background            hybris_blue
#define store_locator_detail_background         hybris_white
#define store_locator_detail_pin_color          hybris_light_gray
#define store_locator_address                   hybris_black
#define store_locator_distance                  hybris_black
#define store_locator_detail_hours_title        hybris_black
#define store_locator_detail_hours              hybris_black
#define store_locator_detail_name               hybris_black
#define store_locator_detail_back               hybris_blue

#define store_locator_detail_back_font          [UIFont fontWithName:@"HelveticaNeue" size:14.f]
#define store_locator_detail_name_font          [UIFont fontWithName:@"HelveticaNeue-Medium" size:18.f]
#define store_locator_detail_address_font       [UIFont fontWithName:@"HelveticaNeue-Medium" size:16.f]
#define store_locator_detail_distance_font      [UIFont fontWithName:@"HelveticaNeue-Medium" size:20.f]
#define store_locator_detail_hours_title_font   [UIFont fontWithName:@"HelveticaNeue-Medium" size:20.f]
#define store_locator_detail_hours_font         [UIFont fontWithName:@"HelveticaNeue-Thin" size:18.f]

#define store_locator_detail_button             hybris_blue
#define store_locator_detail_button_font        [UIFont fontWithName:@"HelveticaNeue-Thin" size:18.f]

//checkout
#define checkout_background             hybris_white
#define checkout_title                  hybris_blue
#define checkout_default_label          hybris_black
#define checkout_question_mark          hybris_black
#define checkout_question_mark_background hybris_gray

#define font_checkout_title                 [UIFont fontWithName:@"HelveticaNeue-Thin" size:26.f]
#define font_checkout_default_label         [UIFont fontWithName:@"HelveticaNeue-Thin" size:18.f]
#define font_checkout_default_label_small   [UIFont fontWithName:@"HelveticaNeue-Thin" size:14.f]

#define checkout_agreement_panel_background hybris_light_gray
#define checkout_agreement_intro            hybris_black
#define checkout_agreement_link             hybris_blue
#define checkout_agreement_confirmation     hybris_red

#define checkout_agreement_button_normal    hybris_gray
#define checkout_agreement_button_selected  hybris_green

#define checkout_order_summary_background   hybris_light_gray

#define checkout_mask   hybris_white

//account
#define account_background             hybris_white
#define account_title                  hybris_blue
#define font_account_title             [UIFont fontWithName:@"HelveticaNeue-Thin" size:26.f]

#define account_default_label                hybris_black
#define font_account_default_label          [UIFont fontWithName:@"HelveticaNeue-Thin" size:18.f]
#define font_account_default_label_small    [UIFont fontWithName:@"HelveticaNeue-Thin" size:14.f]


//settings
#define settings_background             hybris_white
#define settings_title                  hybris_blue
#define font_settings_title             [UIFont fontWithName:@"HelveticaNeue-Thin" size:26.f]

#define settings_default_label          hybris_black
#define font_settings_default_label     [UIFont fontWithName:@"HelveticaNeue-Thin" size:18.f]
#define font_settings_default_label_small    [UIFont fontWithName:@"HelveticaNeue-Thin" size:14.f]


//address form
#define address_form_title              hybris_white
#define font_address_form_title        [UIFont fontWithName:@"HelveticaNeue-Thin" size:26.f]

#define address_form_legend            hybris_black
#define font_address_form_Legend        [UIFont fontWithName:@"HelveticaNeue" size:20.f]

#define address_form_default_label      hybris_black
#define font_address_form_default_label          [UIFont fontWithName:@"HelveticaNeue-Thin" size:18.f]
#define font_address_form_default_label_small    [UIFont fontWithName:@"HelveticaNeue-Thin" size:14.f]

#define address_form_cell_border              hybris_gray

//order summary
#define order_summary_title             hybris_black
#define order_summary_count             hybris_black
#define order_summary_default           hybris_black
#define order_summary_savings           hybris_green
#define order_summary_total             hybris_black

#define order_summary_font_title            [UIFont fontWithName:@"HelveticaNeue-Thin" size:27.f]
#define order_summary_font_count            [UIFont fontWithName:@"HelveticaNeue-Thin" size:24.f]
#define order_summary_font_default          [UIFont fontWithName:@"HelveticaNeue" size:18.f]
#define order_summary_font_total            [UIFont fontWithName:@"HelveticaNeue-Bold" size:18.f]
#define order_summary_font_savings_recap    [UIFont fontWithName:@"HelveticaNeue-Italic" size:16.f]

//order confirmation

#define order_confirmation_background                   hybris_white
#define order_confirmation_continue_button_background   hybris_light_gray
#define order_confirmation_thanks                       hybris_black
#define order_confirmation_default                      hybris_black
#define order_confirmation_title                        hybris_black
#define order_confirmation_link                         hybris_blue

#define order_confirmation_summary_background           hybris_light_gray

#define order_confirmation_table_background             order_confirmation_background

#define order_confirmation_font_thanks      [UIFont fontWithName:@"HelveticaNeue" size:27.f]
#define order_confirmation_font_default     [UIFont fontWithName:@"HelveticaNeue" size:18.f]
#define order_confirmation_font_title       [UIFont fontWithName:@"HelveticaNeue-Bold" size:18.f]

//orders details
#define orders_details_background               hybris_white
#define orders_details_toolbar_background       hybris_light_gray

#define order_details_back_button_background    hybris_clear
#define orders_details_title                    hybris_blue

#define orders_details_number                   hybris_black
#define orders_details_date                     hybris_black
#define orders_details_status                   hybris_black
#define orders_details_tracking_title           hybris_black
#define orders_details_tracking_value           hybris_black

#define orders_details_title_font       [UIFont fontWithName:@"HelveticaNeue-Thin" size:32.f]
#define orders_details_number_font      [UIFont fontWithName:@"HelveticaNeue-Medium" size:25.f]
#define orders_details_date_font        [UIFont fontWithName:@"HelveticaNeue-Thin" size:16.f]
#define orders_details_status_font      [UIFont fontWithName:@"HelveticaNeue-Medium" size:16.f]
#define orders_details_tracking_title_font    [UIFont fontWithName:@"HelveticaNeue-Thin" size:18.f]
#define orders_details_tracking_value_font    [UIFont fontWithName:@"HelveticaNeue" size:18.f]


//product details

#define product_details_header_background   hybris_light_gray
#define product_details_background          hybris_white
#define product_details_default             hybris_blue
#define product_details_header_product_name product_details_default
#define product_details_header_product_code product_details_default
#define product_details_quantity_input_background hybris_light_gray
#define product_details_current_image_bullet product_details_default
#define product_details_default_image_bullet hybris_light_gray

#define product_details_summary             product_details_default
#define product_details_availability        product_details_default
#define product_details_quantity            product_details_default
#define product_details_quantity_input      product_details_default
#define product_details_price               product_details_default
#define product_details_total_price         product_details_default

#define product_details_low_stock            hybris_red

#define product_details_font_default                [UIFont fontWithName:@"HelveticaNeue" size:18.f]
#define product_details_font_header_product_name    [UIFont fontWithName:@"HelveticaNeue" size:22.f]
#define product_details_font_header_product_code    [UIFont fontWithName:@"HelveticaNeue" size:14.f]

#define product_details_font_summary             product_details_font_default
#define product_details_font_availability        product_details_font_default
#define product_details_font_quantity            product_details_font_default
#define product_details_font_quantity_input      product_details_font_default
#define product_details_font_price               product_details_font_default
#define product_details_font_total_price         product_details_font_default

#define product_details_tabs_title_background    hybris_light_gray
#define product_details_tabs_content_background  hybris_light_gray

#define product_details_tabs_title               hybris_black
#define product_details_tabs_content             hybris_black

#define product_details_tabs_title_font         [UIFont fontWithName:@"HelveticaNeue-Medium" size:19.f]
#define product_details_tabs_content_font       [UIFont fontWithName:@"HelveticaNeue" size:17.f]

#define product_details_price_matrix_default     hybris_black
#define product_details_price_matrix_background  hybris_light_gray

#define product_details_price_matrix_quantity_title   product_details_price_matrix_default
#define product_details_price_matrix_price_title      product_details_price_matrix_default

#define product_details_font_price_matrix_quantity_title  [UIFont fontWithName:@"HelveticaNeue-Medium" size:19.f]
#define product_details_font_price_matrix_price_tilte     [UIFont fontWithName:@"HelveticaNeue-Medium" size:19.f]

#define product_details_price_matrix_quantity   product_details_price_matrix_default
#define product_details_price_matrix_price      product_details_price_matrix_default

#define product_details_font_price_matrix_quantity  [UIFont fontWithName:@"HelveticaNeue" size:17.f]
#define product_details_font_price_matrix_price     [UIFont fontWithName:@"HelveticaNeue" size:17.f]

#define product_details_variant_picker_background   hybris_light_gray


//top toolbar
#pragma mark toolbars

#define topToolbar_background           hybris_blue
#define badge_background                hybris_yellow
#define badge_text                      hybris_blue

#define searchbar_results_color         hybris_blue
#define searchbar_background_color      hybris_medium_gray
#define searchbar_dym_background        hybris_medium_gray

#define searchbar_cancel_color          hybris_white

//fonts
#pragma mark fonts

#define font_light_extra_small   [UIFont fontWithName:@"HelveticaNeue-Light" size:12.f]
#define font_light_small   [UIFont fontWithName:@"HelveticaNeue-Light" size:14.f]
#define font_small         [UIFont fontWithName:@"HelveticaNeue" size:16.f]
#define font_small_italic  [UIFont fontWithName:@"HelveticaNeue-Italic" size:16.f]
#define font_medium        [UIFont fontWithName:@"HelveticaNeue" size:18.f]
#define font_medium_italic [UIFont fontWithName:@"HelveticaNeue-Italic" size:18.f]
#define font_medium_bold   [UIFont fontWithName:@"HelveticaNeue-Bold" size:18.f]
#define font_large         [UIFont fontWithName:@"HelveticaNeue" size:32.f]
#define font_title         [UIFont fontWithName:@"HelveticaNeue-Thin" size:32.f]
#define font_subTitle      [UIFont fontWithName:@"HelveticaNeue-Thin" size:20.f]
#define font_subSubTitle   [UIFont fontWithName:@"HelveticaNeue-Thin" size:14.f]


//images
#pragma mark images

#define login_logo_imagename @"Login_logo.png"

#endif
