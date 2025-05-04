package com.example.testejavafx;

import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class HelloApplication extends Application {

    AnchorPane pane;
    Button botao_inicio1, botao_inicio2, botao_Shell, botao_Heap;
    private Button vet[];

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        stage.setTitle("Trabalho PO 1ºBIM");
        pane = new AnchorPane();
        pane.setStyle("-fx-background-color: #26252D;");

        Label titulo = new Label("Animação Métodos de Ordenação");
        titulo.setFont(new Font("Arial", 28));
        titulo.setStyle("-fx-font-weight: bold; -fx-text-fill: #F4F4F4;");
        titulo.setLayoutX(190);
        titulo.setLayoutY(80);
        titulo.getStyleClass().add("titulo");

        Label arthur = new Label("Arthur Liberato Eugênio - 262318881");
        arthur.setFont(new Font("Arial", 17));
        arthur.setStyle("-fx-text-fill: #F4F4F4;");
        arthur.setLayoutX(30);
        arthur.setLayoutY(510);
        arthur.getStyleClass().add("arthur");

        Label jao = new Label("João Claudio Martinez da Costa - 262319640");
        jao.setFont(new Font("Arial", 17));
        jao.setStyle("-fx-text-fill: #F4F4F4;");
        jao.setLayoutX(30);
        jao.setLayoutY(550);
        jao.getStyleClass().add("jao");

        botao_Shell = new Button("Shell");
        botao_Shell.setLayoutX(250); botao_Shell.setLayoutY(300);
        botao_Shell.setMinHeight(50); botao_Shell.setMinWidth(100);
        botao_Shell.setStyle("-fx-text-fill: #F4F4F4; -fx-background-color: #4C9141; -fx-font-size: 20");
        botao_Shell.setOnAction(e -> {
            shellSortStage(stage);});


        botao_Heap = new Button("Heap");
        botao_Heap.setLayoutX(450); botao_Heap.setLayoutY(300);
        botao_Heap.setMinHeight(50); botao_Heap.setMinWidth(100);
        botao_Heap.setStyle("-fx-text-fill: #F4F4F4; -fx-background-color: #4C9141; -fx-font-size: 20");
        botao_Heap.setOnAction(e -> {
            heapSortStage(stage);});

        pane.getChildren().add(arthur);
        pane.getChildren().add(jao);
        pane.getChildren().add(botao_Shell);
        pane.getChildren().add(titulo);
        pane.getChildren().add(botao_Heap);

        Scene scene = new Scene(pane, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    public void cabecario(AnchorPane panel, String titulo) {
        Label label = new Label(titulo);
        label.setLayoutX(270);
        label.setLayoutY(50);
        label.setFont(new Font(30));
        panel.getChildren().add(label);
    }

    public void cabecarioShell(AnchorPane panel, String titulo) {
        Label label = new Label(titulo);
        label.setLayoutX(380);
        label.setLayoutY(50);
        label.setFont(new Font(30));
        label.setStyle("-fx-text-fill: #F4F4F4;");
        panel.getChildren().add(label);
    }

    public int buscaVetor(Button[] vet, String num) {
        int pos = 0;

        while (pos < vet.length && vet[pos] != null && !vet[pos].getText().equals(num)) {
            pos++;
        }

        if (pos < vet.length && vet[pos] != null) {
            return pos;
        }

        return -1;
    }

    public void shellSortStage(Stage stage) { // Recebe o Stage como parâmetro

        AnchorPane novoPane = new AnchorPane(); // Cria um novo painel
        novoPane.setStyle("-fx-background-color: #26252D;");
        int i, LayX=0, num;
        Random rand=new Random();
        cabecarioShell(novoPane, "Ordenação Shell Sort");
        botao_inicio1 = new Button("Iniciar aplicação");
        botao_inicio1.setLayoutX(470);
        botao_inicio1.setLayoutY(320);
        botao_inicio1.setOnAction(e -> shellSortVisual(vet,novoPane));
        novoPane.getChildren().add(botao_inicio1);
        vet = new Button[12];
        int []vetInt=new int[12];
        String str;
        for(i=0;i<12;i++){
            num=rand.nextInt(50);
            str=Integer.toString(num);
            vet[i] = new Button(str);
            vetInt[i]=num;
            //LayX=LayX+80;
            vet[i].setLayoutX(LayX=LayX+80);
            vet[i].setLayoutY(200);
            vet[i].setMinHeight(40);
            vet[i].setMinWidth(40);
            vet[i].setFont(new Font(14));
            novoPane.getChildren().add(vet[i]);
        }
        // Criando botões para os números

        // Cria uma nova cena e atualiza o Stage
        Scene novaCena = new Scene(novoPane, 1050, 600);
        stage.setScene(novaCena);
        stage.show();
    }

    public void heapSortStage(Stage stage) {
        AnchorPane novoPane = new AnchorPane();
        novoPane.setStyle("-fx-background-color: #26252D;");

        int i, LayX = 0, num;
        Random rand = new Random();

        cabecarioShell(novoPane, "Ordenação HeapSort");

        botao_inicio1 = new Button("Iniciar aplicação");
        botao_inicio1.setLayoutX(470);
        botao_inicio1.setLayoutY(320);
        botao_inicio1.setOnAction(e -> {
            botao_inicio1.setVisible(false);
            heapSortVisual(vet, novoPane); // agora passando o AnchorPane também
        });
        novoPane.getChildren().add(botao_inicio1);

        vet = new Button[12];
        int[] vetInt = new int[12];
        String str;

        for (i = 0; i < 12; i++) {
            do {
                num = rand.nextInt(50);
                str = Integer.toString(num);
            } while (buscaVetor(vet, str) != -1); // garante que não se repita

            vet[i] = new Button(str);
            vetInt[i] = num;

            vet[i].setLayoutX(LayX = LayX + 80);
            vet[i].setLayoutY(200);
            vet[i].setMinHeight(40);
            vet[i].setMinWidth(40);
            vet[i].setFont(new Font(14));
            novoPane.getChildren().add(vet[i]);
        }

        Scene novaCena = new Scene(novoPane, 1050, 600);
        stage.setScene(novaCena);
        stage.show();
    }

    public void move_botoes()
    {
        Task<Void> task = new Task<Void>(){

            @Override
            protected Void call() {
            //permutação na tela

                for (int i = 0; i < 10; i++) //vertical
                {
                    Platform.runLater(() -> vet[0].setLayoutY(vet[0].getLayoutY() + 5));
                    System.out.println(vet[0]);
                    Platform.runLater(() -> vet[1].setLayoutY(vet[1].getLayoutY() - 5));

                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                for (int i = 0; i < 16; i++) //horizontal
                {
                    Platform.runLater(() -> vet[0].setLayoutX(vet[0].getLayoutX() + 5));
                    Platform.runLater(() -> vet[1].setLayoutX(vet[1].getLayoutX() - 5));

                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                for (int i = 0; i < 10; i++) //para voltar
                {
                    Platform.runLater(() -> vet[0].setLayoutY(vet[0].getLayoutY() - 5));
                    Platform.runLater(() -> vet[1].setLayoutY(vet[1].getLayoutY() + 5));
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                //permutação na memória
                Button aux = vet[0];
                vet[0] = vet[1];
                vet[1] = aux;
                return null;
            }
        };

        Thread thread = new Thread(task);
        thread.start();
    }

    public void shellSortVisual(Button[] vet, AnchorPane novoPane) {

        Task<Void> task = new Task<>() {
            @Override
            protected Void call() throws Exception {
                Label distTxt = new Label("dist: ");
                distTxt.setFont(new Font("Arial", 16));
                distTxt.setStyle("-fx-text-fill: #F4F4F4;");
                distTxt.setLayoutX(75);
                distTxt.setLayoutY(320);
                Platform.runLater(() -> novoPane.getChildren().add(distTxt));
                int TL = vet.length;
                int dist = 1;
                while (dist < TL) dist = dist * 3 + 1;
                dist = dist / 3;

                while (dist > 0) {
                    int finalDiste = dist;
                    Platform.runLater(() -> distTxt.setText("dist: " + finalDiste));
                    for (int i = dist; i < TL; i++) {
                        int aux=Integer.parseInt(vet[i].getText());
                        int pos=i;

                        while (pos >= dist && aux < Integer.parseInt(vet[pos - dist].getText())) {
                            int finalPos=pos;
                            int finalDist=pos-dist;

                            animacao(vet, finalPos, finalDist);
                            pos=pos-dist;
                        }
                    }
                    dist = dist / 3;
                }
                return null;
            }
        };

        Thread t = new Thread(task);
        t.setDaemon(true);
        t.start();
    }

    private void animacao(Button[] vet, int i, int j) throws InterruptedException {
        if (i != j){
            Button btnI = vet[i];
            Button btnJ = vet[j];

            double xi = btnI.getLayoutX();
            double xj = btnJ.getLayoutX();

            Task<Void> task = new Task<>() {
                @Override
                protected Void call() throws Exception {

                    Platform.runLater(() -> {
                        btnI.setStyle("-fx-background-color: #4C9141; -fx-text-fill: white;");
                        btnJ.setStyle("-fx-background-color: #4C9141; -fx-text-fill: white;");
                    });

                    // 1. Animação vertical para cima/baixo
                    for (int k = 0; k < 10; k++) {
                        Platform.runLater(() -> {
                            btnI.setLayoutY(btnI.getLayoutY() - 5);
                            btnJ.setLayoutY(btnJ.getLayoutY() + 5);
                        });
                        Thread.sleep(30);
                    }

                    // 2. Animação horizontal de troca
                    double passo = (xj - xi) / 16;
                    for (int k = 0; k < 16; k++) {
                        Platform.runLater(() -> {
                            btnI.setLayoutX(btnI.getLayoutX() + passo);
                            btnJ.setLayoutX(btnJ.getLayoutX() - passo);
                        });
                        Thread.sleep(30);
                    }

                    // 3. Volta ao nível original (vertical)
                    for (int k = 0; k < 10; k++) {
                        Platform.runLater(() -> {
                            btnI.setLayoutY(btnI.getLayoutY() + 5);
                            btnJ.setLayoutY(btnJ.getLayoutY() - 5);
                        });
                        Thread.sleep(30);
                    }

                    Platform.runLater(() -> {
                        btnI.setStyle(""); // ou "-fx-background-color: lightgray;" por exemplo
                        btnJ.setStyle("");
                    });

                    // 4. Troca real no vetor após animação
                    Button temp = vet[i];
                    vet[i] = vet[j];
                    vet[j] = temp;
                    return null;
                }

            };

            Thread t = new Thread(task);
            t.setDaemon(true);
            t.start();

            // Espera a thread terminar ANTES de continuar (garante sincronização com o shellSort)
            t.join();
        }
    }

    public void heapSortVisual(Button[] vet, AnchorPane novoPanel) {
        Label paiTxt = new Label("pai: ");
        Label feTxt = new Label("FE: ");
        Label fdTxt = new Label("FD: ");

        paiTxt.setStyle("-fx-text-fill: white;");
        feTxt.setStyle("-fx-text-fill: white;");
        fdTxt.setStyle("-fx-text-fill: white;");

        paiTxt.setLayoutX(100);
        paiTxt.setLayoutY(300);
        feTxt.setLayoutX(100);
        feTxt.setLayoutY(330);
        fdTxt.setLayoutX(100);
        fdTxt.setLayoutY(360);

        novoPanel.getChildren().addAll(paiTxt, feTxt, fdTxt);

        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                int pai, FE, FD, maiorFilho;
                int tl2 = vet.length;

                while (tl2 >= 0) {
                    pai = tl2 / 2 - 1;
                    while (pai >= 0) {
                        FE = pai * 2 + 1;
                        FD = FE + 1;
                        maiorFilho = FE;

                        int finalPai = pai;
                        int finalFE = FE;
                        int finalFD = FD;

                        Platform.runLater(() -> {
                            paiTxt.setText("pai: " + finalPai);
                            feTxt.setText("FE: " + finalFE);
                            fdTxt.setText("FD: " + finalFD);
                        });

                        if (FD < tl2 && Integer.parseInt(vet[FD].getText()) > Integer.parseInt(vet[FE].getText()))
                            maiorFilho = FD;

                        if (Integer.parseInt(vet[pai].getText()) < Integer.parseInt(vet[maiorFilho].getText()))
                            animacao(vet, pai, maiorFilho);

                        pai--;
                    }

                    tl2--;
                    if (tl2 >= 0) {
                        animacao(vet, 0, tl2);

                        int finalTl = tl2; // necessário para usar dentro do Platform.runLater
                        Platform.runLater(() -> {
                            vet[finalTl].setStyle("-fx-background-color: #C0392B; -fx-text-fill: white;"); // vermelho
                        });
                    }
                }

                return null;
            }
        };

        Thread thread = new Thread(task);
        thread.setDaemon(true);
        thread.start();
    }
}