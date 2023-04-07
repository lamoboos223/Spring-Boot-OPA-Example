## Download opa.exe

```sh
wget https://openpolicyagent.org/downloads/latest/opa_windows_amd64.exe
```

First, create your policy files in `.rego` and place them in `./bundles` directory.
Now build the `.rego` file with `opa` executable command (opa.exe).

```sh
opa build bundles/example.rego
```

this will generate `./bundles/bundles.tar.gz` file that will be mounted to `nginx` web server, where `opa engine` will read the policies from.

---
## Testing the policy directly

after building the `.rego` file it will be automaticlly mounted to `nginx` where the opa engine can execute it.
So, to test the policy just execute the following `curl`
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
---
#### Test the application by postman gRPC
<img width="847" alt="Screenshot 2023-04-07 at 3 31 26 AM" src="https://user-images.githubusercontent.com/46426188/230517112-d4e2b12f-c7cf-460b-a777-b014aed0071a.png">
