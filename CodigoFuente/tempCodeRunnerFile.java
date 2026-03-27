import java.util.Random;

public class ContadorFacebookFake {

    // Simula cuántas publicaciones hay realmente
    private static final int TOTAL_PUBLICACIONES_REALES = 6132;

    public static void main(String[] args) {

        int publicacionesContadas = 0;
        int pagina = 1;
        int limitePorPagina = 100;

        System.out.println("Conectando al servidor de Facebook...");
        System.out.println("Solicitando publicaciones del perfil...\n");

        while (publicacionesContadas < TOTAL_PUBLICACIONES_REALES) {

            int publicacionesEnEstaPagina = obtenerPublicacionesFake(
                    publicacionesContadas,
                    limitePorPagina
            );

            publicacionesContadas += publicacionesEnEstaPagina;

            System.out.println(
                "Página " + pagina +
                " -> " + publicacionesEnEstaPagina +
                " publicaciones (Total: " + publicacionesContadas + ")"
            );

            pagina++;

            // Simula latencia de red
            dormir(300);
        }

        System.out.println("\nConteo finalizado");
        System.out.println("Total de publicaciones del perfil: " + publicacionesContadas);
    }

    // Simula la respuesta de Facebook
    private static int obtenerPublicacionesFake(int yaContadas, int limite) {
        int restantes = TOTAL_PUBLICACIONES_REALES - yaContadas;
        return Math.min(restantes, limite);
    }

    private static void dormir(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
