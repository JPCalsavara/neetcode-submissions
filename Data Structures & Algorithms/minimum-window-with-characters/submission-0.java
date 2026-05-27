class Solution {
    public String minWindow(String s, String t) {
        // Escudo de segurança
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        // O nosso "Mapa" ultrarrápido usando a tabela ASCII
        int[] targetFreq = new int[128];
        
        // Registrando a nossa dívida inicial
        for (char c : t.toCharArray()) {
            targetFreq[c]++;
        }

        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int startIndex = 0; // Para lembrarmos onde a menor janela começou
        
        // Quantas letras úteis ainda precisamos encontrar?
        int lettersNeeded = t.length(); 

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            
            // Se essa letra é uma das que estamos devendo, diminuímos o que falta encontrar
            if (targetFreq[rightChar] > 0) {
                lettersNeeded--;
            }
            
            // Colocamos a letra na nossa janela (se for inútil, o saldo fica negativo, o que significa "excesso")
            targetFreq[rightChar]--;
            right++; // Expandimos a janela

            // O CÃO DE GUARDA: A dívida foi paga! A janela atual tem TUDO o que precisamos.
            while (lettersNeeded == 0) {
                
                // 1. É a menor janela que já vimos? Se sim, anota o recorde!
                if (right - left < minLength) {
                    minLength = right - left;
                    startIndex = left;
                }

                // 2. Vamos tentar encolher a janela pelo lado esquerdo
                char leftChar = s.charAt(left);
                
                // Tiramos a letra da janela (devolvemos para o banco)
                targetFreq[leftChar]++;
                
                // Se o saldo dessa letra no banco ficou maior que zero, 
                // significa que acabamos de perder uma letra essencial!
                if (targetFreq[leftChar] > 0) {
                    lettersNeeded++; // A dívida volta a subir, quebrando o laço 'while'
                }
                
                left++; // Encolhemos a janela
            }
        }

        // Se o minLength nunca foi alterado, é porque nunca achamos uma janela válida
        return minLength == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLength);
    }
}