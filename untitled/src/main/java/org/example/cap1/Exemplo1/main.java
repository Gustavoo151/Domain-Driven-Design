package org.example.cap1.Exemplo1;

public class main {

    public static void main(String[] args) {

    }

    // Essa é a primeira implementação onde vamos salvar uma carga e uma viagem e retornar seu ID.
    public int makeBooking(Cargo cargo, Voyage voyage){
        int confirmation = orderConfirmartionSequence.next();
        voyage.addCargo(cargo, confirmation);
        return confirmation;
    }


    // Agora vamos adicionar um requisito que será de overbooking de 10% na segunda implementação
}
