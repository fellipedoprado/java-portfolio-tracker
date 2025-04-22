import com.dio.portfoliotracker.model.Customer;
import com.dio.portfoliotracker.model.Portfolio;
import com.dio.portfoliotracker.model.Position;
import com.dio.portfoliotracker.model.asset.Asset;
import com.dio.portfoliotracker.model.asset.Crypto;
import com.dio.portfoliotracker.model.asset.Equity;
import com.dio.portfoliotracker.model.asset.Fund;
import java.math.BigDecimal;



public class App {
    public static void main(String[] args) throws Exception {
        // Criar cliente
        Customer cliente = new Customer("João Silva", "joao@email.com", null);

        // Criar carteira e associar ao cliente
        Portfolio carteira = new Portfolio(cliente, null);
        cliente.addPortfolio(carteira);

        // Criar alguns ativos
        Asset acaoPETR = new Equity("PETR4", "Petrobras", new BigDecimal("32.80"));
        Asset fundoImob = new Fund("HGLG11", "FII Logística", new BigDecimal("170.00"));
        Asset bitcoin = new Crypto("BTC", "Bitcoin", new BigDecimal("180000.00"));

        // Criar posições
        Position posPETR = new Position(acaoPETR, new BigDecimal("100"), new BigDecimal("30.00"));
        Position posFII = new Position(fundoImob, new BigDecimal("10"), new BigDecimal("150.00"));
        Position posBTC = new Position(bitcoin, new BigDecimal("0.02"), new BigDecimal("150000.00"));

        // Adicionar posições à carteira
        carteira.addPosition(posPETR);
        carteira.addPosition(posFII);
        carteira.addPosition(posBTC);

        // Gerar relatório
        System.out.println("\nRelatório da carteira:");
        carteira.generateReport();
    }
}
