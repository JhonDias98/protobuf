package br.com.zup

import java.io.FileInputStream
import java.io.FileOutputStream

fun main() {
    val request = FuncionarioRequest.newBuilder()
        .setNome("Jonathan Dias")
        .setCpf("000.000.000-00")
        .setSalario(2500.0)
        .setAtivo(true)
        .setCargo(Cargo.DEV)
        .addEndereco(FuncionarioRequest.Endereco.newBuilder()
                            .setLogradouro("Logo Ali")
                            .setCep("00000-000")
                            .setComplemento("Casa 01")
                            .build())
        .build()
    println(request)

    //Escrevemos o arquivo
    request.writeTo(FileOutputStream("funcionario-request.bin"))

    //Lemos o arquivo
    val request2 = FuncionarioRequest.newBuilder()
            .mergeFrom(FileInputStream("funcionario-request.bin"))

    request2.setCargo(Cargo.GERENTE)
        .build()
    println(request2)

}