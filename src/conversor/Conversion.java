package conversor;

import java.math.BigDecimal;

public record Conversion(
        String base_code,
        String target_code,
        BigDecimal conversion_rate,
        BigDecimal conversion_result
) {
    @Override
    public String toString() {
        return String.format(
                "Conversión: %s → %s | Monto convertido: %.2f (Tasa: %.4f)",
                base_code,
                target_code,
                conversion_result,
                conversion_rate
        );
    }
}