import org.springframework.cloud.contract.spec.Contract
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType

Contract.make {
    description("Should return all receipts")

    request {
        method("GET")
        url("/receipts")
    }
    response {
        status(HttpStatus.OK.value())
        headers {
            contentType(MediaType.APPLICATION_JSON_VALUE)
        }
        body(
                [[uuid: "20020wofbf", taxpayerInn: "5260307811", amount: 100.00]]
        )
    }
}