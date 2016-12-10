# dns-update-server
A 'fake dns' type service to store public IPs.

## Install instructions
1. Deploy to Tomcat server or run Dockerised version from `dns-update-server-deploy` project.

## Usage
* Resource (GET) ```query?hostName=mymachine``` - retrieves the currently stored IP for "mymachine"
* Resource (POST) ```update``` - updates the IP for hostname. Payload: ```{"ip":"17.0.9.2", "hostName": "mymachine"}```

## Future improvements
1. Security
2. More unit tests
