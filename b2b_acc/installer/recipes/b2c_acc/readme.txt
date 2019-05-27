This recipe provides everything you need to install SAP Hybris Commerce Responsive B2C Commerce Accelerator with Smart Edit, Promotions Engine, Coupons, Textfield Configurator, Assisted Services and Customer Ticketing addons.

Required Configurations:
* For features that require a Google API key (such as the Store Locator, which uses Google Maps), you need to set the “googleApiKey”. For information on generating your API Key: https://developers.google.com/maps/documentation/javascript/tutorial#api_key
* For Kyma integration + ApiRegistry, event sending is turned off by default by apiregistryservices.events.exporting=false property. Optionally and before initialization, deployment.api.endpoint property should be set to a server url reachable by kyma instead of https://localhost:9002.