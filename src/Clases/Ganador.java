
package Clases;

public class Ganador {
    
    public char coincidenciaLinea(char[][]matriz,char simboloPorDefecto) {
        char simbolo;
        boolean coincidencia;
        for (int i = 0; i < matriz.length; i++) {
            coincidencia = true;
            simbolo = matriz[i][0];
            if (simbolo != simboloPorDefecto) {
                for (int j = 1; j < matriz[0].length; j++) {
                    if (simbolo != matriz[i][j]) {
                        coincidencia = false;
                    }
                }
                if (coincidencia) {
                    return simbolo;
                }
            }
        }
        return simboloPorDefecto;
    }
    
    public char coincidenciaColumna(char[][]matriz,char simboloPorDefecto) {
        char simbolo;
        boolean coincidencia;
        for (int j = 0; j < matriz.length; j++) {
            coincidencia = true;
            simbolo = matriz[0][j];
            if (simbolo != simboloPorDefecto) {
                for (int i = 1; i < matriz[0].length; i++) {
                    if (simbolo != matriz[i][j]) {
                        coincidencia = false;
                    }
                }
                if (coincidencia) {
                    return simbolo;
                }
            }
        }
        return simboloPorDefecto;

    }
    
    public char coincidenciaDiagonal(char[][]matriz,char simboloPorDefecto) {
        char simbolo;
        boolean coincidencia = true;
        simbolo = matriz[0][0];
        if (simbolo != simboloPorDefecto) {
            for (int i = 1; i < matriz.length; i++) {
                if (simbolo != matriz[i][i]) {
                    coincidencia = false;
                }
            }
            if (coincidencia) {
                return simbolo;
            }
        }
        coincidencia = true;

        // diagonal inversa
        simbolo = matriz[0][2];
        if (simbolo != simboloPorDefecto) {
            for (int i = 1, j = 1; i < matriz.length; i++, j--) {
                if (simbolo != matriz[i][j]) {
                    coincidencia = false;
                }
            }
            if (coincidencia) {
                return simbolo;
            }
        }
        return simboloPorDefecto;

    }
    
    public boolean validarGanador(char[][]matriz, char simboloPorDefecto) {
        char simbolo = coincidenciaLinea(matriz,simboloPorDefecto);
        if (simbolo != simboloPorDefecto) {
            return true;
        }
        simbolo = coincidenciaColumna(matriz,simboloPorDefecto);

        if (simbolo != simboloPorDefecto) {
            return true;
        }
        simbolo = coincidenciaDiagonal(matriz,simboloPorDefecto);
        if (simbolo != simboloPorDefecto) {
            return true;
        }
        return false;
    }
    
     public boolean existeEmpate(int intentos,char[][]matriz,char simboloPorDefecto) {
        boolean empate = false;
        boolean posicionocupada = false;
        if (intentos >= 9) {
            if(matriz[0][0]!= simboloPorDefecto && matriz[0][1] != simboloPorDefecto &&
               matriz[0][2] != simboloPorDefecto && matriz[1][0] != simboloPorDefecto &&
               matriz[1][1] != simboloPorDefecto && matriz[1][2] != simboloPorDefecto &&
               matriz[2][0] != simboloPorDefecto && matriz[2][1] != simboloPorDefecto &&
               matriz[2][2] != simboloPorDefecto)
            {
                posicionocupada = true;
            }
            else
            {
                posicionocupada = false;
            }
        }
        if (posicionocupada && !this.validarGanador(matriz,simboloPorDefecto)) {
            empate = true;
        }
        return empate;
    }
}
