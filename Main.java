import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Quiz quiz = new Quiz();

        quiz.adicionarQuestao(new Questao("Qual é o nome do protagonista de \"The Legend of Zelda\"?", "A) Link", "B) Zelda", "C) Ganondorf", "D) Epona", "E) Navi", "A"));
        quiz.adicionarQuestao(new Questao("Em \"Super Mario Bros\", qual é o nome do irmão de Mario?", "A) Luigi", "B) Wario", "C) Yoshi", "D) Toad", "E) Bowser", "A"));
        quiz.adicionarQuestao(new Questao("Qual jogo popular apresenta uma ilha habitada por animais antropomórficos e permite que o jogador gerencie a ilha?", "A) Animal Crossing", "B) Stardew Valley", "C) Harvest Moon", "D) The Sims", "E) Minecraft", "A"));
        quiz.adicionarQuestao(new Questao("Em que ano foi lançado o primeiro jogo da série \"Call of Duty\"?", "A) 2001", "B) 2003", "C) 2005", "D) 2007", "E) 2009", "B"));
        quiz.adicionarQuestao(new Questao("Qual jogo de RPG tem como principal mecânica a captura e o treinamento de monstros chamados \"Pokémon\"?", "A) Digimon", "B) Final Fantasy", "C) Pokémon", "D) Dragon Quest", "E) Monster Hunter", "C"));
        quiz.adicionarQuestao(new Questao("Em \"Minecraft\", qual é o nome do material necessário para criar uma mesa de encantamento?", "A) Diamante", "B) Obsidiana", "C) Ferro", "D) Ouro", "E) Carvão", "B"));
        quiz.adicionarQuestao(new Questao("Qual é o nome do personagem principal em \"God of War\"?", "A) Ares", "B) Kratos", "C) Zeus", "D) Hades", "E) Hermes", "B"));
        quiz.adicionarQuestao(new Questao("Em \"League of Legends\", quantos jogadores compõem uma equipe padrão?", "A) 3", "B) 4", "C) 5", "D) 6", "E) 7", "C"));
        quiz.adicionarQuestao(new Questao("Qual é o objetivo principal do jogo \"Among Us\"?", "A) Construir bases", "B) Completar tarefas e descobrir os impostores", "C) Capturar bandeiras", "D) Coletar recursos", "E) Derrotar monstros", "B"));
        quiz.adicionarQuestao(new Questao("Em \"The Elder Scrolls V: Skyrim\", como se chama o dragão principal que o jogador deve derrotar?", "A) Alduin", "B) Paarthurnax", "C) Dragonborn", "D) Odahviing", "E) Mirmulnir", "A"));
        quiz.adicionarQuestao(new Questao("Qual é o nome do planeta natal de Master Chief em \"Halo\"?", "A) Reach", "B) Earth", "C) Sanghelios", "D) Harvest", "E) Eridanus II", "E"));
        quiz.adicionarQuestao(new Questao("Em \"Fortnite\", qual é a principal mecânica de construção?", "A) Construir armas", "B) Construir estruturas de defesa e ataque", "C) Construir veículos", "D) Construir cidades inteiras", "E) Construir personagens", "B"));
        quiz.adicionarQuestao(new Questao("Qual jogo de corrida tem a famosa pista \"Rainbow Road\"?", "A) Need for Speed", "B) Gran Turismo", "C) Forza Horizon", "D) Mario Kart", "E) Asphalt", "D"));
        quiz.executar();
    }

    static class Questao {
        private String pergunta;
        private String opcaoA;
        private String opcaoB;
        private String opcaoC;
        private String opcaoD;
        private String opcaoE;
        private String correta;

        public Questao(String pergunta, String opcaoA, String opcaoB, String opcaoC, String opcaoD, String opcaoE, String correta) {
            this.pergunta = pergunta;
            this.opcaoA = opcaoA;
            this.opcaoB = opcaoB;
            this.opcaoC = opcaoC;
            this.opcaoD = opcaoD;
            this.opcaoE = opcaoE;
            this.correta = correta;
        }

        public void escrevaQuestao() {
            System.out.println(this.pergunta);
            System.out.println(this.opcaoA);
            System.out.println(this.opcaoB);
            System.out.println(this.opcaoC);
            System.out.println(this.opcaoD);
            System.out.println(this.opcaoE);
            System.out.println();
        }

        public String leiaResposta() {
            Scanner ler = new Scanner(System.in);
            String resp;
            do {
                System.out.println("Digite a resposta: ");
                resp = ler.next();
            } while (!respostaValida(resp));
            return resp;
        }

        private boolean respostaValida(String resp) {
            if (resp.equalsIgnoreCase("A") ||
                    resp.equalsIgnoreCase("B") ||
                    resp.equalsIgnoreCase("C") ||
                    resp.equalsIgnoreCase("D") ||
                    resp.equalsIgnoreCase("E")) {
                return true;
            }
            System.out.println("Resposta inválida! digite opção A,B,C,D ou E.");
            System.out.println();
            return false;
        }

        public boolean isCorreta(String resposta) {
            if (resposta.equalsIgnoreCase(this.correta)) {
                System.out.println("Parabéns resposta correta! - Letra: " + this.correta);
                System.out.println();
                return true;
            } else {
                System.out.println("Resposta errada!");
                System.out.println("A resposta correta é: " + this.correta);
                System.out.println();
                return false;
            }
        }
    }
}

class Quiz {

    private List<Main.Questao> questoes;

    public Quiz() {
        questoes = new ArrayList<>();
    }

    public void adicionarQuestao(Main.Questao questao) {
        questoes.add(questao);
    }

    public void executar() {
        for (Main.Questao questao : questoes) {
            questao.escrevaQuestao();
            String resposta = questao.leiaResposta();
            questao.isCorreta(resposta);
        }
    }
}
