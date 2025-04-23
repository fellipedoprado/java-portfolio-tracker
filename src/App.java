import com.dio.portfoliotracker.exception.CustomerException;
import com.dio.portfoliotracker.model.Customer;
import com.dio.portfoliotracker.model.Portfolio;
import com.dio.portfoliotracker.model.Position;
import com.dio.portfoliotracker.model.asset.Asset;
import com.dio.portfoliotracker.model.asset.Crypto;
import com.dio.portfoliotracker.model.asset.Equity;
import com.dio.portfoliotracker.model.asset.Fund;
import java.math.BigDecimal;

public class App {

    public static void main(String[] args) {
        testInvalidCustomerCreation();
        testInvalidPortfolioCreation();
        testInvalidPositionCreation();
        testDuplicatePosition();
        testValidScenario();
    }

    private static void testInvalidCustomerCreation() {
    System.out.println("\nTesting Invalid Customer Creation:");
    try {
        Customer cliente = new Customer(null, "João Silva", null);
    } catch (CustomerException e) {
        System.err.println("Customer validation error: " + e.getMessage());
    } catch (RuntimeException e) {
        System.err.println("Unexpected runtime error: " + e.getMessage());
        e.printStackTrace();
    }
    }

    private static void testInvalidPortfolioCreation() {
        System.out.println("\nTesting Invalid Portfolio Creation:");
        try {
            Portfolio carteira = new Portfolio(null, null);
        } catch (Exception e) {
            System.err.println("Expected error: " + e.getMessage());
        }
    }

    private static void testInvalidPositionCreation() {
        System.out.println("\nTesting Invalid Position Creation:");
        try {
            Asset acaoPETR = new Equity("PETR4", "Petrobras", new BigDecimal("32.80"));
            Position posPETR = new Position(acaoPETR, new BigDecimal("100"), new BigDecimal("-30.00"));
        } catch (Exception e) {
            System.err.println("Expected error: " + e.getMessage());
        }
    }

    private static void testDuplicatePosition() {
        System.out.println("\nTesting Duplicate Position:");
        try {
            Customer cliente = new Customer("joao@email.com", "João Silva", null);
            Portfolio carteira = new Portfolio(cliente, null);
            
            Asset acaoPETR = new Equity("PETR4", "Petrobras", new BigDecimal("32.80"));
            Position posPETR1 = new Position(acaoPETR, new BigDecimal("100"), new BigDecimal("30.00"));
            Position posPETR2 = new Position(acaoPETR, new BigDecimal("50"), new BigDecimal("32.00"));
            
            carteira.addPosition(posPETR1); // Should succeed
            carteira.addPosition(posPETR2); // Should throw exception
        } catch (Exception e) {
            System.err.println("Expected error: " + e.getMessage());
        }
    }

    private static void testValidScenario() {
        System.out.println("\nTesting Valid Scenario:");
        try {
            // Criar cliente
            Customer cliente = new Customer("joao@email.com", "João Silva", null);

            // Criar carteira e associar ao cliente
            Portfolio carteira = new Portfolio(cliente, null);
            cliente.addPortfolio(carteira);

            // Criar alguns ativos
            Asset acaoPETR = new Equity("PETR4", "Petrobras", new BigDecimal("32.80"));
            Asset fundoImob = new Fund("HGLG11", "FII Logística", new BigDecimal("170.00"));
            Asset bitcoin = new Crypto("BTC", "Bitcoin", new BigDecimal("180000.00"));

            // Criar posições válidas
            Position posPETR = new Position(acaoPETR, new BigDecimal("100"), new BigDecimal("30.00"));
            Position posFII = new Position(fundoImob, new BigDecimal("10"), new BigDecimal("150.00"));
            Position posBTC = new Position(bitcoin, new BigDecimal("0.02"), new BigDecimal("150000.00"));

            // Adicionar posições à carteira
            carteira.addPosition(posPETR);
            carteira.addPosition(posFII);
            carteira.addPosition(posBTC);

            System.out.println("Todos os cenários válidos executados com sucesso!");
            System.out.println("\nRelatório da carteira:");
            carteira.generateReport();

        } catch (Exception e) {
            System.err.println("Unexpected error in valid scenario: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
