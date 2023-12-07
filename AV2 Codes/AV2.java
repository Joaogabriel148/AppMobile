public class AV2 extends AppCompatActivity {
    private BinaryTree binaryTree;
    private TextView tvItemList, tvLongestCommonSubsequence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_av2);

        binaryTree = new BinaryTree();
        tvItemList = findViewById(R.id.tvItemList);
        tvLongestCommonSubsequence = findViewById(R.id.tvLongestCommonSubsequence);

        Button btnAddRandomItem = findViewById(R.id.btnAddRandomItem);
        btnAddRandomItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Adicionar um item aleatório à árvore binária
                String randomKey = generateRandomString();
                String randomValue = generateRandomString();
                binaryTree.insert(randomKey, randomValue);

                // Atualizar a exibição na tela
                updateItemList();
            }
        });

        Button btnFindLongestCommonSubsequence = findViewById(R.id.btnFindLongestCommonSubsequence);
        btnFindLongestCommonSubsequence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Encontrar e exibir a maior subsequência comum
                updateLongestCommonSubsequence();
            }
        });

        // Exemplo inicial - adicione mais lógica conforme necessário
        // Para exibir a árvore binária inicialmente
        updateItemList();
    }

    private void updateItemList() {
        // Atualizar o TextView com os itens da árvore binária
        StringBuilder itemList = new StringBuilder("Itens na Árvore Binária:\n");

        for (BinaryTree.TreeNode node : binaryTree.getSortedItems()) {
            itemList.append("Key: ").append(node.key).append(", Value: ").append(node.value).append("\n");
        }

        tvItemList.setText(itemList.toString());
    }

    private void updateLongestCommonSubsequence() {
        // Encontrar a maior subsequência comum entre dois itens aleatórios
        BinaryTree.TreeNode[] randomItems = binaryTree.getRandomItems();

        if (randomItems.length >= 2) {
            String longestCommonSubsequence = binaryTree.findLongestCommonSubsequence(randomItems[0].value, randomItems[1].value);
            tvLongestCommonSubsequence.setText("Maior Subsequência Comum: " + longestCommonSubsequence);
        } else {
            tvLongestCommonSubsequence.setText("Adicione pelo menos dois itens à árvore.");
        }
    }

    // Método para gerar uma string aleatória (apenas para fins de exemplo)
    private String generateRandomString() {
        int length = 5;  // ajuste conforme necessário
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomString = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            randomString.append(characters.charAt(index));
        }

        return randomString.toString();
    }
}
