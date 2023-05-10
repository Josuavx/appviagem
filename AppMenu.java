import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class AppMenu {

    static int idViagem;
    static int idVeiculo;
    static int kmOdometro;
    static Scanner teclado = new Scanner(System.in);
    static int opcao;
    static List<Veiculo> veiculos = new ArrayList();
    static List<Viagem> viagens = new ArrayList();
    static SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args)throws ParseException {

        while (true) {

            System.out.println("1 - Cadastrar veículo\n2 - Consultar veículo\n3 - Programar viagem\n4 - Consultar viagem\n5 - Iniciar viagem\n6 - Finalizar viagem\n7 - Colocar veículo em manutenção\n0 - Finalizar");
            System.out.println("Digite a opcao: ");
            opcao = teclado.nextInt();


            switch (opcao) {
                case 0:
                    System.out.println("Programa finalizado.");
                    break;

                case 1:
                    System.out.println("Id veículo: ");
                    idVeiculo = teclado.nextInt();

                    System.out.println("Placa veiculo: ");
                    String placa = teclado.next();

                    System.out.println("Km do odometro: ");
                    kmOdometro = teclado.nextInt();

                    cadastrarVeiculo(idVeiculo, placa, kmOdometro);
                    break;

                case 2:
                    System.out.println("Id veículo procurado: ");
                    idVeiculo = teclado.nextInt();

                    consultarVeiculo(idVeiculo);
                    break;

                case 3:
                    System.out.println("Id da viagem: ");
                    idViagem = teclado.nextInt();

                    System.out.println("Destino da viagem: ");
                    String destino = teclado.next();

                    System.out.println("Data inicial(dd/MM/yyyy): ");
                    String dInicial = teclado.next();
                    Date dataInicial = formato.parse(dInicial);

                    System.out.println("Data final(dd/MM/yyyy): ");
                    String dFinal = teclado.next();
                    Date dataFinal = formato.parse(dFinal);

                    programarViagem(idViagem, destino, dataInicial, dataFinal);
                    break;

                case 4:
                    System.out.println("Id da viagem: ");
                    idViagem = teclado.nextInt();

                    consultarViagem(idViagem);
                    break;

                case 5:
                    System.out.println("Id da viagem: ");
                    idViagem = teclado.nextInt();

                    System.out.println("Id veículo: ");
                    idVeiculo = teclado.nextInt();

                    iniciarViagem(idViagem, idVeiculo);
                    break;

                case 6:
                    System.out.println("Id da viagem: ");
                    idViagem = teclado.nextInt();

                    System.out.println("Km odometro: ");
                    kmOdometro = teclado.nextInt();
                    finalizarViagem(kmOdometro, idViagem);
                    break;

                case 7:
                    System.out.println("Id veículo: ");
                    idVeiculo = teclado.nextInt();

                    manutencao(idVeiculo);
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;

            }
            if (opcao == 0){
                break;
            }
        }


    }


    public static Veiculo procurarVeiculo(int id){
        Veiculo veiculoEncontrado = null;

        for (Veiculo veiculo : veiculos) {
            if (veiculo.getIdVeiculo() == id) {
                veiculoEncontrado = veiculo;
                return veiculoEncontrado;
            }
        }

        Veiculo vazio = null;
        return vazio;
    }

    public static Viagem procurarViagem(int id){
        Viagem viagemEncontrada = null;

        for (Viagem viagem : viagens) {
            if (viagem.getIdViagem() == id) {
                viagemEncontrada = viagem;
                return viagemEncontrada;
            }
        }

        Viagem vazia = null;
        return vazia;
    }

    public static void cadastrarVeiculo(int id, String placa, int kmOdometro) {
        Veiculo veiculoEncontrado = procurarVeiculo(id);
        if (veiculoEncontrado != null){
            System.out.println("Veículo já cadastrado.");
            return;
        }

        Veiculo veiculo = new Veiculo(id, placa, kmOdometro);
        veiculos.add(veiculo);

        System.out.println("Veiculo cadastrado com sucesso");

    }

    public static void consultarVeiculo(int id){
        Veiculo veiculoEncontrado = procurarVeiculo(id);

        if (veiculoEncontrado != null){
            System.out.println("Id: "+ veiculoEncontrado.getIdVeiculo());
            System.out.println("Placa: "+ veiculoEncontrado.getPlaca());
            System.out.println("Status: "+ veiculoEncontrado.getStatus());
            System.out.println("Odometro: "+ veiculoEncontrado.getKmOdometro());
            return;
        }

        System.out.println("Veículo não cadastrado.");
    }

    public static void programarViagem(int idViagem, String destino, Date dataInicial, Date dataFinal){
        Viagem viagemEncontrada = procurarViagem(idViagem);
        if (viagemEncontrada != null){
            System.out.println("Viagem já existente.");
            return;
        }

        Viagem viagem = new Viagem(idViagem, destino, dataInicial, dataFinal);


        viagens.add(viagem);
        System.out.println("Viagem programada.");
    }

    public static void consultarViagem(int idViagem){
        for (Viagem viagem : viagens){
            if (viagem.getIdViagem() == idViagem){
                System.out.println("Id: "+ viagem.getIdViagem());
                System.out.println("Destino: "+ viagem.getDestino());
                System.out.println("Data inicial: "+ viagem.getDataInicial());
                System.out.println("Data final: "+ viagem.getDataFinal());
                System.out.println("Km percorrido: "+ viagem.getKmPercorrido());

                if (viagem.getVeiculo() == null){
                    System.out.println("Sem veículo");
                }else{
                    System.out.println("Id do veículo: "+ viagem.getVeiculo().getIdVeiculo());
                }

                return;
            }
        }

        System.out.println("Não tem viagem programada");
    }

    public static void iniciarViagem(int idViagem, int idVeiculo){
        Veiculo veiculoEncontrado = procurarVeiculo(idVeiculo);
        Viagem viagemEncontrada = procurarViagem(idViagem);

        if (veiculoEncontrado == null){
            System.out.println("Veículo não encontrado");
            return;
        }
        if (viagemEncontrada == null){
            System.out.println("Viagem não encontrada");
            return;
        }
        if(veiculoEncontrado.getStatus() == 'V'){
            System.out.println("O veículo não está disponível porque já está em viagem");
            return;
        }
        if(veiculoEncontrado.getStatus() == 'M'){
            System.out.println("O veículo não está disponível porque está em manutenção");
            return;
        }
        if(viagemEncontrada.getVeiculo() != null && viagemEncontrada.getKmPercorrido() == 0){
            System.out.println("Viagem já foi iniciada");
            return;
        }
        if(viagemEncontrada.getVeiculo() != null && viagemEncontrada.getKmPercorrido() != 0){
            System.out.println("Viagem já foi finalizada");
            return;
        }

        viagemEncontrada.iniciarViagem(veiculoEncontrado);
        System.out.println("Viagem iniciada");
    }

    public static void finalizarViagem(int kmOdometro, int idViagem){
        Viagem viagemEncontrada = procurarViagem(idViagem);

        if (viagemEncontrada == null){
            System.out.println("Viagem não programada.");
        }
        if (viagemEncontrada.getVeiculo() == null){
            System.out.println("Viagem não foi iniciada.");
            return;
        }
        if (viagemEncontrada.getKmPercorrido() != 0){
            System.out.println("Viagem já foi finalizada.");
            return;
        }

        viagemEncontrada.finalizarViagem(kmOdometro);
        System.out.println("Viagem finalizada.");
    }

    public static void manutencao(int idVeiculo){
        Veiculo veiculoEncontrado = procurarVeiculo(idVeiculo);
        if (veiculoEncontrado == null){
            System.out.println("Veículo não encontrado");
            return;
        }
        if (veiculoEncontrado.getStatus() == 'M'){
            System.out.println("Veículo já está em manutenção. ");
        }

        veiculoEncontrado.revisar();
        System.out.println("Veículo foi colocado em manutenção.");
    }
}