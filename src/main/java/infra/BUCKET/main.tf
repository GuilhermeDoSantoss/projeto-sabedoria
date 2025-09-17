// Configuração de um servidor Bucket

resource = "aws_s3_bucket" "bucket" {
    bucket = var.bucket_name
    }