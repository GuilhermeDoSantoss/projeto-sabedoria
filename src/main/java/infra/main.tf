provider "aws"{
    region = "us-east-1"
}

resource "aws_security_group" "securitygroup" {
   name = "security"
   description = "Permitir acesso HTTP e acesso a Internet"

  ingress {
       from_port = 80
       to_port = 80
       protocol = "tcp"
       cidr_blocks = ["0.0.0.0/0"]
   }

    ingress {
          from_port = 22
          to_port = 22
          protocol = "tcp"
          cidr_blocks = ["0.0.0.0/0"]
      }

    egress {
        from_port = 0
        to_port = 65535
        protocol = "tcp"
        cidr_blocks = ["0.0.0.0/0"]
    }

}

resource "aws_key_pair" "keypair"{
    key_name = "terraform-keypair"
    public_key = file("") // entra a chave publica
    }

resource "aws_instance" "servidor" {
    ami            = "ami-oc101f26f147fa7fd"
    instance_type = "t2.nano" // maquina simples e grátis da aws
    user_data     = file("user_data.sh")
    key_name = aws_key_pair.keypair.key_name
    vpc_security_group_ids = [awx_security_group.securitygroup.id]
}