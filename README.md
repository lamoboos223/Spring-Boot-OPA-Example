


> opa build bundles/example.rego




```shell
curl --location 'http://localhost:8181/v1/data/httpapi/authz' \
--header 'Content-Type: application/json' \
--data '{
    "input": {
        "user": "charlie",
        "path": ["finance", "salary", "alice"],
        "method": "GET"
    }
}'
```

#### Test the application by postman gRPC
<img width="847" alt="Screenshot 2023-04-07 at 3 31 26 AM" src="https://user-images.githubusercontent.com/46426188/230517112-d4e2b12f-c7cf-460b-a777-b014aed0071a.png">
