package br.com.zup

import io.grpc.ManagedChannelBuilder

fun main() {

    val channel = ManagedChannelBuilder
        .forAddress("localhost", 50051)
        .usePlaintext()
        .build()

    val request = FuncionarioRequest.newBuilder()
        .setNome("Jonathan Dias")
        .setCpf("000.000.000-00")
        .setIdade(23)
        .setSalario(2500.0)
        .setAtivo(true)
        .setCargo(Cargo.DEV)
        .addEndereco(FuncionarioRequest.Endereco.newBuilder()
            .setLogradouro("Logo Ali")
            .setCep("00000-000")
            .setComplemento("Casa 01")
            .build())
        .build()

    val client = FuncionarioServiceGrpc.newBlockingStub(channel)
    val response = client.cadastrar(request)
    println(response)

}