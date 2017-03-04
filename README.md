# dns-update-server
A 'fake dns' type service to store public IPs.

## Install instructions
1. Deploy to Tomcat server or run Dockerised version from `dns-update-server-deploy` project.

## Usage
* Resource (GET) ```query?hostName=mymachine``` - retrieves the currently stored IP for "mymachine"
* Resource (POST) ```update``` - updates the IP for hostname. Payload: ```{"ip":"17.0.9.2", "hostName": "mymachine"}```

## A note on security
* This project now includes ```Resource Owner Password Credentials Grant``` OAuth2 security. As this 
requires Basic Auth for requesting bearer tokens, it should always be deployed onto a server that uses SSL. The
endpoint for tokens is at ```oath/token``` and uses the standard OAuth2 headers / parameters.

## Future improvements
1. More unit tests
