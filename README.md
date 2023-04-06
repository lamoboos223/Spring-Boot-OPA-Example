


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