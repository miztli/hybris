This recipe provides everything you need to install SAP Hybris Commerce accelerator for China with Flash Buy, Alipay Integration, Baidu Map Integration, Wechat Pay Integration and Customer Coupon addons. 
This accelerator has similar configuration as b2c_acc and adapted for China.


Required Configurations:
* For features that require a Baidu API key (such as the Store Locator, which uses Baidu Maps), you need to set the “baiduApiKey”
* For features which related to Alipay Integration and Wechat Pay Integration, please refer to https://help.hybris.com/
* For Kyma integration + ApiRegistry, event sending is turned off by default by apiregistryservices.events.exporting=false property. Optionally and before initialization, deployment.api.endpoint property should be set to a server url reachable by kyma instead of https://localhost:9002.
