class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        // O laço não tem o sinal de igual (l < r).
        // Quando l e r se encontrarem na mesma posição, o laço quebra
        // e nós teremos certeza absoluta de que estamos pisando no menor número.
        while (l < r) {
            
            // A nossa fórmula anti-overflow (A régua de distância)
            int mid = l + (r - l) / 2;

            // CENÁRIO 1: Estamos no planalto alto. O abismo está para a frente.
            if (nums[mid] > nums[r]) {
                // O 'mid' é muito alto, o menor NÃO é ele. Podemos pular ele com segurança.
                l = mid + 1;
            } 
            // CENÁRIO 2: Estamos no planalto baixo. O abismo está para trás (ou estamos nele).
            else {
                // A direita está perfeitamente ordenada. 
                // O menor número está para a esquerda, ou é o próprio 'mid'. 
                // Por isso NÃO fazemos mid - 1.
                r = mid;
            }
        }

        // Quando l e r colidem, o abismo foi encontrado!
        return nums[l];
    }
}