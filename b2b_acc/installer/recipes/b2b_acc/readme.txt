Ext-gen B2B Accelerator, based on yacceleratorstorefront, with B2B Accelerator, Commerce Organization, Assisted Services, Customer Ticketing, Promotions Engine, Coupons, Textfield Configurator and Smart Edit addons.

Required Configurations:
* For features that require a Google API key (such as the Store Locator, which uses Google Maps), you need to set the “googleApiKey”. For information on generating your API Key: https://developers.google.com/maps/documentation/javascript/tutorial#api_key
* For Kyma integration + ApiRegistry, event sending is turned off by default by apiregistryservices.events.exporting=false property. Optionally and before initialization, deployment.api.endpoint property should be set to a server url reachable by kyma instead of https://localhost:9002.
