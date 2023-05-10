import java.util.Date;

public class Viagem {
    private int idViagem;
    private String destino;
    private Date dataInicial;
    private Date dataFinal;
    private int kmPercorrido;
    private Veiculo veiculo;


    public Viagem(int idViagem, String destino, Date dataInicial, Date dataFinal) {
        this.idViagem = idViagem;
        this.destino = destino;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.kmPercorrido = 0;
    }

    public boolean iniciarViagem(Veiculo veiculo){
        if (veiculo.getStatus() == 'D'){
            this.veiculo = veiculo;
            this.dataInicial = new Date();
            this.veiculo.registrarViagem();

            return true;
        }
        return false;
    }

    public void finalizarViagem(int kmOdometro){
        this.dataFinal = new Date();
        this.kmPercorrido = calcularKmPercorrido(kmOdometro);
        this.veiculo.registrarRetorno(kmPercorrido);
    }

    public int calcularKmPercorrido(int kmOdometro){
        return kmOdometro - this.veiculo.getKmOdometro();
    }


    public int getIdViagem() {
        return idViagem;
    }

    public String getDestino() {
        return destino;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public int getKmPercorrido() {
        return kmPercorrido;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }
}
