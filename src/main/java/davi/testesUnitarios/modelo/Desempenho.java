
package davi.testesUnitarios.modelo;

import java.math.BigDecimal;

/**
 *
 * @author davi_
 */
public enum Desempenho {
    
    RUIM {
        @Override
        public BigDecimal percentual() {
            return new BigDecimal("0.03");
        }
    },
    BOM {
        @Override
        public BigDecimal percentual() {
            return new BigDecimal("0.15");
        }
    },
    EXCELENTE {
        @Override
        public BigDecimal percentual() {
            return new BigDecimal("0.20");
        }
    };
    
    public abstract BigDecimal percentual();
}
