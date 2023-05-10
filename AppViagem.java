import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class AppViagem {
    public static void main(String[] args)throws ParseException{
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        Date dataInicial = formato.parse("07/04/2023");
        Date dataFinal = formato.parse("08/04/2023");


        Viagem viagem = new Viagem(1, "Paris", dataInicial, dataFinal);
        System.out.println("Id: "+ viagem.getIdViagem());
        System.out.println("Destino: "+ viagem.getDestino());
        System.out.println("Data inicial: "+ viagem.getDataInicial());
        System.out.println("Data final: "+ viagem.getDataFinal());
        System.out.println("Kms percorridos: "+ viagem.getKmPercorrido());

        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        Veiculo veiculo = new Veiculo(1, "BRA354", 1000);
        viagem.iniciarViagem(veiculo);


        System.out.println("Veiculo obj: "+ viagem.getVeiculo());
        System.out.println("Data inicial viagem: "+ viagem.getDataInicial());
        System.out.println("Data final viagem: "+ viagem.getDataFinal());
        System.out.println("Id do veículo da viagem: "+ viagem.getVeiculo().getIdVeiculo());
        System.out.println("Placa do veículo da viagem: "+ viagem.getVeiculo().getPlaca());
        System.out.println("Odometro do veículo da viagem: "+ viagem.getVeiculo().getKmOdometro());
        System.out.println("Status do veículo da viagem: "+ viagem.getVeiculo().getStatus());

        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        viagem.finalizarViagem(1500);

        System.out.println("Data inicial viagem: "+ viagem.getDataInicial());
        System.out.println("Data final viagem: "+ viagem.getDataFinal());
        System.out.println("Km percorrido: "+ viagem.getKmPercorrido());
        System.out.println("Id do veículo da viagem: "+ viagem.getVeiculo().getIdVeiculo());
        System.out.println("Placa do veículo da viagem: "+ viagem.getVeiculo().getPlaca());
        System.out.println("Odometro do veículo da viagem: "+ viagem.getVeiculo().getKmOdometro());
        System.out.println("Status do veículo da viagem: "+ viagem.getVeiculo().getStatus());

        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        veiculo.revisar();
        System.out.println("Id do veículo da viagem: "+ viagem.getVeiculo().getIdVeiculo());
        System.out.println("Placa do veículo da viagem: "+ viagem.getVeiculo().getPlaca());
        System.out.println("Odometro do veículo da viagem: "+ viagem.getVeiculo().getKmOdometro());
        System.out.println("Status do veículo da viagem: "+ viagem.getVeiculo().getStatus());

    }

}
