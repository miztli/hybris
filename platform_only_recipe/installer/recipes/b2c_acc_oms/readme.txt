B2C Accelerator with OMS 
For Kyma integration + ApiRegistry, event sending is turned off by default by apiregistryservices.events.exporting=false property. Optionally and before initialization, deployment.api.endpoint property should be set to a server url reachable by kyma instead of https://localhost:9002.
 Platform Setup:
   1. Setup platform using command ./install.sh -r b2c_acc_oms setup
   2. Initialize platform using command ./install.sh -r b2c_acc_oms initialize
   3. Start platform using command ./install.sh -r b2c_acc_oms start
	