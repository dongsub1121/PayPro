package com.nicepayment.paypro.model.argument

enum class PaymentMethod {
    PayPro,
    Link,
    Other
}
enum class BarcodeType {
    QR,
    Barcode
}

enum class PaymentStatus {
    Authorization,
    Ready,
    Cancel,
    Unknown
}

enum class ProtocolState {
    Authorization,
    Inquiry,
    NetCancel
}