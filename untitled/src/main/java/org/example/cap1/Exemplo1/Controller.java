package org.example.cap1.Exemplo1;

public class Controller {

    OrderConfirmartionSequence orderConfirmartionSequence = new OrderConfirmartionSequence();

    // Nesses métodos abaixo poderiamos usar o padrão STRATEGY. Ele é geralmente motivado pela necessidade de substituir
    // regras diferentes.

    // Essa é a primeira implementação onde vamos salvar uma carga e uma viagem e retornar seu ID.
    public int makeBooking1(Cargo cargo, Voyage voyage){
        int confirmation = orderConfirmartionSequence.next(); // Pega o id da confirmação
        voyage.addCargo(cargo, confirmation);
        return confirmation;
    }


// Agora vamos adicionar um regra de negócio que será de overbooking de 10% na segunda implementação
    // Segunda implentação (Dessa maneira o conhecimento dessa regra de negócio está acoplado a um método)
    public int makeBooking2(Cargo cargo, Voyage voyage){
        double maxBooking = voyage.capacity() * 1.1;  // Aqui ele vai receber a capacidade de carga e vai recever a os 10 % do overbooking

        if ((voyage.bookedCargoSize() + cargo.size()) > maxBooking)  // Se o tamanho reservado mais o tamanho da carga for maior que maxBooking return -1
            return -1;

        int confirmation = orderConfirmartionSequence.next();   // Pega o id da confirmação
        voyage.addCargo(cargo, confirmation);
        return confirmation;
    }


    // Terceira Implentação
    // Na terceira implementação vamos criar uma classe nova onde será feita a politica de overbooking. Com ela fica
//    claro para todos que o overbooking é uma política, e a implementação dessa regra é explícita e separada.

    OverbookingPolicy overbookingPolicy = new OverbookingPolicy();

    public int makeBooking3(Cargo cargo, Voyage voyage){
        if(!overbookingPolicy.isAllowed(cargo, voyage))
            return -1;

        int confirmation = orderConfirmartionSequence.next();   // Pega o id da confirmação
        voyage.addCargo(cargo, confirmation);
        return confirmation;
    }
}
