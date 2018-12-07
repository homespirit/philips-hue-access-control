# philips-hue-access-control
A proxy for the Philips Hue Bridge providing access control

## Concept
```
+--------------------------------------+
|                                      |
|          Philips Hue Bridge          |
|   ^                              |   |
|   |                  API Response|   |
|   |                              |   |
+--------------------------------------+
    |                              |
+--------------------------------------+
|   |                              |   |
|   |Sanitized API Call            |   |
|   |                              v   |
|                                      |
|                                      |
|   Philips Hue Access Control Proxy   |
|                                      |
|                                      |
|   ^                              |   |
|   |        Sanitized API Response|   |
|   |                              |   |
+--------------------------------------+
    |                              |
+--------------------------------------+
|   |                              |   |
|   |API Call                      |   |
|   |                              v   |
|               Devices                |
|                                      |
+--------------------------------------+
```
