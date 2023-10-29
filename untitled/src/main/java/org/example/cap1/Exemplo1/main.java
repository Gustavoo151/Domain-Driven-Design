package org.example.cap1.Exemplo1;

public class main {

    public static void main(String[] args) {

    }

    // Essa é a primeira implementação onde vamos salvar uma carga e uma viagem e retornar seu ID.
    public int makeBooking(Cargo cargo, Voyage voyage){
        int confirmation = orderConfirmartionSequence.next(); // Pega o id da confirmação
        voyage.addCargo(cargo, confirmation);
        return confirmation;
    }


    // Segunda implentação
    // Agora vamos adicionar um requisito que será de overbooking de 10% na segunda implementação
    public int makeBooking(Cargo cargo, Voyage voyage){
        double maxBooking = voyage.capacity();  // Aqui ele vai receber a capacidade de carga

        if ((voyage.bookedCargoSize() + cargo.size()) > maxBooking)  // Se o tamanho reservado mais o tamanho da carga for maior que maxBooking return -1
            return -1;

        int confirmation = orderConfirmartionSequence.next();   // Pega o id da confirmação
        voyage.addCargo(cargo, confirmation);
        return confirmation;
    }
}
