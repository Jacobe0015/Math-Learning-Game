package com.example.mathlearninggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    Button button_submit, button_pause;
    TextView question, allquestions, lives, timerNum;
    EditText textUserAnswer;
    Random random = new Random();
    int num1, num2, temp, numQuestions;
    int counter = 0, correct = 0, wrong = 0;
    long start, finish, time = 60000;
    String type;
    StringBuilder questions = new StringBuilder();
    CountDownTimer countDown;
    boolean buttonFlag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button_submit = findViewById(R.id.button_submit);
        question = findViewById(R.id.textView_Question);
        lives = findViewById(R.id.lives);
        textUserAnswer = findViewById(R.id.answer);
        allquestions = findViewById(R.id.questions);
        timerNum = findViewById(R.id.timerNum);
        button_pause = findViewById(R.id.pause);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            type = extras.getString("type");
        }

        //Mixed
        if (type.equals("mix")) {
            String array[] = {"add", "sub", "mul", "div"};
            int rnd = random.nextInt(array.length);

            switch (rnd) {
                //Mix Add
                case 0:
                    num1 = random.nextInt(100);
                    num2 = random.nextInt(100);
                    question.setText("What is " + num1 + "+" + num2 + "?");


                    button_submit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int userAnswer = Integer.parseInt(textUserAnswer.getText().toString());
                            int actualAnswer = num1 + num2;

                            if (userAnswer == actualAnswer) {
                                question.setText("You are Correct!");
                            } else {
                                question.setText("You are Wrong!");
                            }

                            textUserAnswer.setText("");
                        }
                    });
                    break;

                //Mix Sub
                case 1:
                    num1 = random.nextInt(100);
                    num2 = random.nextInt(100);
                    if (num2 > num1) {
                        temp = num1;
                        num1 = num2;
                        num2 = temp;

                    }
                    question.setText("What is " + num1 + "-" + num2 + "?");


                    button_submit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int userAnswer = Integer.parseInt(textUserAnswer.getText().toString());
                            int actualAnswer = num1 - num2;

                            if (userAnswer == actualAnswer) {
                                question.setText("You are Correct!");
                            } else {
                                question.setText("You are Wrong!");
                            }

                            textUserAnswer.setText("");
                        }
                    });
                    break;

                //Mix Multiply
                case 2:
                    num1 = random.nextInt(12);
                    num2 = random.nextInt(12);
                    question.setText("What is " + num1 + "x" + num2 + "?");


                    button_submit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int userAnswer = Integer.parseInt(textUserAnswer.getText().toString());
                            int actualAnswer = (num1 * num2);

                            if (userAnswer == actualAnswer) {
                                question.setText("You are Correct!");
                            } else {
                                question.setText("You are Wrong!");
                            }

                            textUserAnswer.setText("");
                        }
                    });

                    break;

                //Mix Divide
                case 3:
                    float num1 = random.nextInt(12);
                    float num2 = random.nextInt(12);
                    question.setText("What is " + num1 + "/" + num2 + "?");


                    button_submit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            float userAnswer = Float.parseFloat(textUserAnswer.getText().toString());
                            float actualAnswer = (num1 / num2);
                            actualAnswer = Math.round(actualAnswer * 100);
                            actualAnswer = actualAnswer / 100;


                            if (userAnswer == actualAnswer) {
                                question.setText("You are Correct!");
                            } else {
                                question.setText("You are Wrong!");
                                System.out.println(actualAnswer);
                            }

                            textUserAnswer.setText("");
                        }
                    });
                    break;


                default:
                    break;
            }


        }

        // Addition
        if (type.equals("add")) {

            num1 = random.nextInt(100);
            num2 = random.nextInt(100);
            question.setText("What is " + num1 + "+" + num2 + "?");


            button_submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int userAnswer = Integer.parseInt(textUserAnswer.getText().toString());
                    int actualAnswer = num1 + num2;

                    if (userAnswer == actualAnswer) {
                        question.setText("You are Correct!");
                    } else {
                        question.setText("You are Wrong!");
                    }

                    textUserAnswer.setText("");
                }
            });
        }

        // Subtraction
        if (type.equals("sub")) {

            num1 = random.nextInt(100);
            num2 = random.nextInt(100);

            // If num2 is greater than num1, switch the values.
            if (num2 > num1) {
                temp = num1;
                num1 = num2;
                num2 = temp;

            }
            question.setText("What is " + num1 + "-" + num2 + "?");

            button_submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int userAnswer = Integer.parseInt(textUserAnswer.getText().toString());
                    int actualAnswer = num1 - num2;

                    if (userAnswer == actualAnswer) {
                        question.setText("You are Correct!");
                    } else {
                        question.setText("You are Wrong!");
                    }

                    textUserAnswer.setText("");
                }
            });
        }

        // Multiplication
        if (type.equals("mul")) {
            num1 = random.nextInt(12);
            num2 = random.nextInt(12);
            question.setText("What is " + num1 + "x" + num2 + "?");

            button_submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int userAnswer = Integer.parseInt(textUserAnswer.getText().toString());
                    int actualAnswer = (num1 * num2);

                    if (userAnswer == actualAnswer) {
                        question.setText("You are Correct!");
                    } else {
                        question.setText("You are Wrong!");
                    }

                    textUserAnswer.setText("");
                }
            });
        }

        //Division
        if (type.equals("div")) {

            float num1 = random.nextInt(12);
            float num2 = random.nextInt(12);
            question.setText("What is " + num1 + "/" + num2 + "?");
            float actualAnswer = (num1 / num2);
            actualAnswer = Math.round(actualAnswer * 100);
            actualAnswer = actualAnswer / 100;
            System.out.println(actualAnswer);


            button_submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    float userAnswer = Float.parseFloat(textUserAnswer.getText().toString());
                    float actualAnswer = (num1 / num2);
                    actualAnswer = Math.round(actualAnswer * 100);
                    actualAnswer = actualAnswer / 100;


                    if (userAnswer == actualAnswer) {
                        question.setText("You are Correct!");
                    } else {
                        question.setText("You are Wrong!");
                        System.out.println(actualAnswer);
                    }

                    textUserAnswer.setText("");
                }
            });
        }

        //mix

        if (type.equals("wishAdd")) {
            question.setText("How many questions do you want?");

            button_submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    numQuestions = Integer.parseInt(textUserAnswer.getText().toString());
                    button_submit.setText("Submit Answer");
                    wishAddQuestions();
                    textUserAnswer.setText("");
                    start = System.currentTimeMillis();

                }
            });
        }

        if (type.equals("wishMul")) {
            question.setText("How many questions do you want?");

            button_submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    numQuestions = Integer.parseInt(textUserAnswer.getText().toString());
                    button_submit.setText("Submit Answer");
                    wishMulQuestions();
                    textUserAnswer.setText("");
                    start = System.currentTimeMillis();

                }
            });
        }

        //if (type.equals("wishSub"))
        //if (type.equals("wishDiv"))

        if (type.equals("mistakeAdd")) {
            question.setText("How many questions do you want?");

            button_submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    numQuestions = Integer.parseInt(textUserAnswer.getText().toString());
                    button_submit.setText("Submit Answer");
                    noMistakeAddQuestions();
                    textUserAnswer.setText("");
                    start = System.currentTimeMillis();

                }
            });
        }

        if (type.equals("mistakeMul")){
            question.setText("How many questions do you want?");

            button_submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    numQuestions = Integer.parseInt(textUserAnswer.getText().toString());
                    button_submit.setText("Submit Answer");
                    noMistakeMulQuestions();
                    textUserAnswer.setText("");
                    start = System.currentTimeMillis();

                }
            });
        }

        //if (type.equals("mistakeSub"))
        //if (type.equals("mistakeDiv"))


        //Make a separate screen option for mixed questions.
        if (type.equals("mixChance")) {
            String array[] = {"add", "sub", "mul", "div"};
            wrong = 3;
            lives.setText("Lives: " + wrong);
            int rnd = random.nextInt(array.length);

            switch (rnd) {
                //Mix Add
                case 0:
                    num1 = random.nextInt(100);
                    num2 = random.nextInt(100);
                    question.setText("What is " + num1 + "+" + num2 + "?");


                    button_submit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int userAnswer = Integer.parseInt(textUserAnswer.getText().toString());
                            int actualAnswer = num1 + num2;

                            if (userAnswer == actualAnswer) {
                                questions.append(num1);
                                questions.append("+");
                                questions.append(num2);
                                questions.append(" (Correct)\n");
                                correct += 1;
                                takeChanceQuestions();

                            } else {
                                questions.append(num1);
                                questions.append("+");
                                questions.append(num2);
                                questions.append(" (Wrong)\n");
                                wrong -= 1;
                                lives.setText("Lives: " + wrong);
                                takeChanceQuestions();
                            }

                            textUserAnswer.setText("");
                        }
                    });
                    break;

                //Mix Sub
                case 1:
                    num1 = random.nextInt(100);
                    num2 = random.nextInt(100);
                    if (num2 > num1) {
                        temp = num1;
                        num1 = num2;
                        num2 = temp;

                    }
                    question.setText("What is " + num1 + "-" + num2 + "?");


                    button_submit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int userAnswer = Integer.parseInt(textUserAnswer.getText().toString());
                            int actualAnswer = num1 - num2;

                            if (userAnswer == actualAnswer) {
                                questions.append(num1);
                                questions.append("-");
                                questions.append(num2);
                                questions.append(" (Correct)\n");
                                correct += 1;
                                takeChanceQuestions();
                            } else {
                                questions.append(num1);
                                questions.append("-");
                                questions.append(num2);
                                questions.append(" (Wrong)\n");
                                wrong -= 1;
                                lives.setText("Lives: " + wrong);
                                takeChanceQuestions();
                            }

                            textUserAnswer.setText("");
                        }
                    });
                    break;

                //Mix Multiply
                case 2:
                    num1 = random.nextInt(12);
                    num2 = random.nextInt(12);
                    question.setText("What is " + num1 + "x" + num2 + "?");


                    button_submit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int userAnswer = Integer.parseInt(textUserAnswer.getText().toString());
                            int actualAnswer = (num1 * num2);

                            if (userAnswer == actualAnswer) {
                                questions.append(num1);
                                questions.append("x");
                                questions.append(num2);
                                questions.append(" (Correct)\n");
                                correct += 1;
                                takeChanceQuestions();
                            } else {
                                questions.append(num1);
                                questions.append("x");
                                questions.append(num2);
                                questions.append(" (Wrong)\n");
                                wrong -= 1;
                                lives.setText("Lives: " + wrong);
                                takeChanceQuestions();
                            }

                            textUserAnswer.setText("");
                        }
                    });

                    break;

                //Mix Divide
                case 3:
                    float num1 = random.nextInt(12);
                    float num2 = random.nextInt(12);
                    question.setText("What is " + num1 + "/" + num2 + "?");


                    button_submit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            float userAnswer = Float.parseFloat(textUserAnswer.getText().toString());
                            float actualAnswer = (num1 / num2);
                            actualAnswer = Math.round(actualAnswer * 100);
                            actualAnswer = actualAnswer / 100;


                            if (userAnswer == actualAnswer) {
                                questions.append(num1);
                                questions.append("/");
                                questions.append(num2);
                                questions.append(" (Correct)\n");
                                takeChanceQuestions();


                            } else {
                                questions.append(num1);
                                questions.append("/");
                                questions.append(num2);
                                questions.append(" (Wrong)\n");
                                wrong -= 1;
                                lives.setText("Lives: " + wrong);
                                takeChanceQuestions();
                            }

                            textUserAnswer.setText("");
                        }
                    });
                    break;


                default:
                    break;
            }

        }

        if (type.equals("mixTimeTrial")){
            timerStart();
            timeTrialQuestions();
        }
    }

    public void additionQuestion() {
        num1 = random.nextInt(100);
        num2 = random.nextInt(100);
        question.setText("What is " + num1 + "+" + num2 + "?");
    }

    public void subtractionQuestion() {
        num1 = random.nextInt(100);
        num2 = random.nextInt(100);

        if (num2 > num1) {
            temp = num1;
            num1 = num2;
            num2 = temp;
        }
        question.setText("What is " + num1 + "-" + num2 + "?");
    }

    public void multiplicationQuestion() {
        num1 = random.nextInt(12);
        num2 = random.nextInt(12);
        question.setText("What is " + num1 + "x" + num2 + "?");
    }

    public void divisionQuestion() {
        float num1 = random.nextInt(12);
        float num2 = random.nextInt(12);
        question.setText("What is " + num1 + "/" + num2 + "?");
    }

    public void mixQuestion() {
        String array[] = {"add", "sub", "mul", "div"};
        int rnd = random.nextInt(array.length);

        switch (rnd) {
            case 0:
                num1 = random.nextInt(100);
                num2 = random.nextInt(100);
                question.setText("What is " + num1 + "+" + num2 + "?");

                button_submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int userAnswer = Integer.parseInt(textUserAnswer.getText().toString());
                        int actualAnswer = num1 + num2;

                        if (userAnswer == actualAnswer) {
                            question.setText("You are Correct!");
                        } else {
                            question.setText("You are Wrong!");
                        }

                        textUserAnswer.setText("");
                    }
                });

                break;

            case 1:
                num1 = random.nextInt(100);
                num2 = random.nextInt(100);

                if (num2 > num1) {
                    temp = num1;
                    num1 = num2;
                    num2 = temp;
                }
                question.setText("What is " + num1 + "-" + num2 + "?");

                button_submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int userAnswer = Integer.parseInt(textUserAnswer.getText().toString());
                        int actualAnswer = num1 - num2;

                        if (userAnswer == actualAnswer) {
                            question.setText("You are Correct!");
                        } else {
                            question.setText("You are Wrong!");
                        }

                        textUserAnswer.setText("");
                    }
                });
                break;

            case 2:
                num1 = random.nextInt(12);
                num2 = random.nextInt(12);
                question.setText("What is " + num1 + "x" + num2 + "?");

                button_submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int userAnswer = Integer.parseInt(textUserAnswer.getText().toString());
                        int actualAnswer = (num1 * num2);

                        if (userAnswer == actualAnswer) {
                            question.setText("You are Correct!");
                        } else {
                            question.setText("You are Wrong!");
                        }

                        textUserAnswer.setText("");
                    }
                });
                break;

            case 3:

                float num1 = random.nextInt(12);
                float num2 = random.nextInt(12);

                question.setText("What is " + num1 + "/" + num2 + "?");

                button_submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        float userAnswer = Float.parseFloat(textUserAnswer.getText().toString());
                        float actualAnswer = (num1 / num2);
                        actualAnswer = Math.round(actualAnswer * 100);
                        actualAnswer = actualAnswer / 100;


                        if (userAnswer == actualAnswer) {
                            question.setText("You are Correct!");
                        } else {
                            question.setText("You are Wrong!");
                            System.out.println(actualAnswer);
                        }

                        textUserAnswer.setText("");
                    }
                });
                break;
        }

    }

    public void wishAddQuestions() {

        num1 = random.nextInt(100);
        num2 = random.nextInt(100);
        question.setText("What is " + num1 + "+" + num2 + "?");

        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int userAnswer = Integer.parseInt(textUserAnswer.getText().toString());
                int actualAnswer = num1 + num2;

                if (userAnswer == actualAnswer && counter <= numQuestions) {
                    questions.append(num1);
                    questions.append("+");
                    questions.append(num2);
                    questions.append(" (Correct)\n");
                    correct += 1;
                    counter++;
                    wishAddQuestions();

                }
                if (userAnswer != actualAnswer && counter <= numQuestions) {
                    questions.append(num1);
                    questions.append("+");
                    questions.append(num2);
                    questions.append(" (Wrong)\n");
                    counter++;
                    wishAddQuestions();
                }

                if (counter == numQuestions) {
                    finish = System.currentTimeMillis();
                    float time = (finish - start) / 1000;
                    question.setText("\t GAME OVER \n\t Your Score: " + correct + "\n\t Time Taken: " + time + "s");
                    allquestions.setText(questions.toString());
                }
                textUserAnswer.setText("");
            }
        });

    }

    public void wishMulQuestions(){
        num1 = random.nextInt(12);
        num2 = random.nextInt(12);
        question.setText("What is " + num1 + "x" + num2 + "?");

        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int userAnswer = Integer.parseInt(textUserAnswer.getText().toString());
                int actualAnswer = num1 * num2;

                if (userAnswer == actualAnswer && counter <= numQuestions) {
                    questions.append(num1);
                    questions.append("x");
                    questions.append(num2);
                    questions.append(" (Correct)\n");
                    correct += 1;
                    counter++;
                    wishMulQuestions();

                }
                if (userAnswer != actualAnswer && counter <= numQuestions) {
                    questions.append(num1);
                    questions.append("x");
                    questions.append(num2);
                    questions.append(" (Wrong)\n");
                    counter++;
                    wishMulQuestions();
                }

                if (counter == numQuestions) {
                    finish = System.currentTimeMillis();
                    float time = (finish - start) / 1000;
                    question.setText("\t GAME OVER \n\t Your Score: " + correct + "\n\t Time Taken: " + time + "s");
                    allquestions.setText(questions.toString());
                }
                textUserAnswer.setText("");
            }
        });
    }

    public void noMistakeAddQuestions() {
        num1 = random.nextInt(100);
        num2 = random.nextInt(100);
        question.setText("What is " + num1 + "+" + num2 + "?");

        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int userAnswer = Integer.parseInt(textUserAnswer.getText().toString());
                int actualAnswer = num1 + num2;

                if (userAnswer == actualAnswer && counter <= numQuestions && wrong != 1) {
                    questions.append(num1);
                    questions.append("+");
                    questions.append(num2);
                    questions.append(" (Correct)\n");
                    correct += 1;
                    counter++;
                    noMistakeAddQuestions();


                }
                if (userAnswer != actualAnswer && counter <= numQuestions && wrong != 1) {
                    questions.append(num1);
                    questions.append("+");
                    questions.append(num2);
                    questions.append(" (Wrong)\n");
                    wrong += 1;
                    noMistakeAddQuestions();
                }

                if (counter == numQuestions || wrong == 1) {
                    finish = System.currentTimeMillis();
                    float time = (finish - start) / 1000;
                    button_submit.setVisibility(View.INVISIBLE);
                    question.setText("\t GAME OVER \n\t Your Score: " + correct + "\n\t Time Taken: " + time + "s");
                    allquestions.setText(questions.toString());

                    /*
                    for (int j = 0; j <= questions.size(); j++) {
                        allquestions.append(questions.get(j));
                        allquestions.append(answer.get(j));
                        allquestions.append("\n");
                    }
                    */
                }
                textUserAnswer.setText("");
            }
        });
    }

    public void noMistakeMulQuestions() {
        num1 = random.nextInt(12);
        num2 = random.nextInt(12);
        question.setText("What is " + num1 + "x" + num2 + "?");

        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int userAnswer = Integer.parseInt(textUserAnswer.getText().toString());
                int actualAnswer = num1 * num2;

                if (userAnswer == actualAnswer && counter <= numQuestions && wrong != 1) {
                    questions.append(num1);
                    questions.append("x");
                    questions.append(num2);
                    questions.append(" (Correct)\n");
                    correct += 1;
                    counter++;
                    noMistakeMulQuestions();


                }
                if (userAnswer != actualAnswer && counter <= numQuestions && wrong != 1) {
                    questions.append(num1);
                    questions.append("x");
                    questions.append(num2);
                    questions.append(" (Wrong)\n");
                    wrong += 1;
                    noMistakeMulQuestions();
                }

                if (counter == numQuestions || wrong == 1) {
                    finish = System.currentTimeMillis();
                    float time = (finish - start) / 1000;
                    button_submit.setVisibility(View.INVISIBLE);
                    question.setText("\t GAME OVER \n\t Your Score: " + correct + "\n\t Time Taken: " + time + "s");
                    allquestions.setText(questions.toString());

                    /*
                    for (int j = 0; j <= questions.size(); j++) {
                        allquestions.append(questions.get(j));
                        allquestions.append(answer.get(j));
                        allquestions.append("\n");
                    }
                    */
                }
                textUserAnswer.setText("");
            }
        });
    }

    public void takeChanceQuestions() {
        String array[] = {"add", "sub", "mul", "div"};
        int rnd = random.nextInt(array.length);

        if(wrong == 0){
            endProgram();
        }

        if (wrong != 0) {
            switch (rnd) {
                case 0:
                    num1 = random.nextInt(100);
                    num2 = random.nextInt(100);
                    question.setText("What is " + num1 + "+" + num2 + "?");

                    button_submit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int userAnswer = Integer.parseInt(textUserAnswer.getText().toString());
                            int actualAnswer = num1 + num2;

                            if (userAnswer == actualAnswer) {
                                questions.append(num1);
                                questions.append("+");
                                questions.append(num2);
                                questions.append(" (Correct)\n");
                                correct += 1;
                                takeChanceQuestions();
                            } else {
                                questions.append(num1);
                                questions.append("+");
                                questions.append(num2);
                                questions.append(" (Wrong)\n");
                                wrong -= 1;
                                lives.setText("Lives: " + wrong);
                                takeChanceQuestions();

                            }

                            textUserAnswer.setText("");
                        }
                    });

                    break;

                case 1:
                    num1 = random.nextInt(100);
                    num2 = random.nextInt(100);

                    if (num2 > num1) {
                        temp = num1;
                        num1 = num2;
                        num2 = temp;
                    }
                    question.setText("What is " + num1 + "-" + num2 + "?");

                    button_submit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int userAnswer = Integer.parseInt(textUserAnswer.getText().toString());
                            int actualAnswer = num1 - num2;

                            if (userAnswer == actualAnswer) {
                                questions.append(num1);
                                questions.append("-");
                                questions.append(num2);
                                questions.append(" (Correct)\n");
                                correct += 1;
                                takeChanceQuestions();
                            } else {
                                questions.append(num1);
                                questions.append("-");
                                questions.append(num2);
                                questions.append(" (Wrong)\n");
                                wrong -= 1;
                                lives.setText("Lives: " + wrong);
                                takeChanceQuestions();

                            }

                            textUserAnswer.setText("");
                        }
                    });
                    break;

                case 2:
                    num1 = random.nextInt(12);
                    num2 = random.nextInt(12);
                    question.setText("What is " + num1 + "x" + num2 + "?");

                    button_submit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int userAnswer = Integer.parseInt(textUserAnswer.getText().toString());
                            int actualAnswer = (num1 * num2);

                            if (userAnswer == actualAnswer) {
                                questions.append(num1);
                                questions.append("x");
                                questions.append(num2);
                                questions.append(" (Correct)\n");
                                correct += 1;
                                takeChanceQuestions();
                            } else {
                                questions.append(num1);
                                questions.append("x");
                                questions.append(num2);
                                questions.append(" (Wrong)\n");
                                wrong -= 1;
                                lives.setText("Lives: " + wrong);
                                takeChanceQuestions();
                            }

                            textUserAnswer.setText("");
                        }
                    });
                    break;

                case 3:

                    float num1 = random.nextInt(12);
                    float num2 = random.nextInt(12);

                    question.setText("What is " + num1 + "/" + num2 + "?");

                    button_submit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            float userAnswer = Float.parseFloat(textUserAnswer.getText().toString());
                            float actualAnswer = (num1 / num2);
                            actualAnswer = Math.round(actualAnswer * 100);
                            actualAnswer = actualAnswer / 100;


                            if (userAnswer == actualAnswer) {
                                questions.append(num1);
                                questions.append("/");
                                questions.append(num2);
                                questions.append(" (Correct)\n");
                                correct += 1;
                                takeChanceQuestions();
                            } else {
                                questions.append(num1);
                                questions.append("/");
                                questions.append(num2);
                                questions.append(" (Wrong))\n");
                                wrong -= 1;
                                lives.setText("Lives: " + wrong);
                                takeChanceQuestions();
                            }

                            textUserAnswer.setText("");
                        }
                    });
                    break;
            }

        }
    }

    public void timeTrialQuestions(){
        String array[] = {"add", "sub", "mul", "div"};
        int rnd = random.nextInt(array.length);
        switch (rnd) {
            //Mix Add
            case 0:
                num1 = random.nextInt(100);
                num2 = random.nextInt(100);
                question.setText("What is " + num1 + "+" + num2 + "?");


                button_submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int userAnswer = Integer.parseInt(textUserAnswer.getText().toString());
                        int actualAnswer = num1 + num2;

                        if (userAnswer == actualAnswer) {
                            questions.append(num1);
                            questions.append("+");
                            questions.append(num2);
                            questions.append(" (Correct)\n");
                            correct += 1;
                            timeTrialQuestions();

                        } else {
                            questions.append(num1);
                            questions.append("+");
                            questions.append(num2);
                            questions.append(" (Wrong)\n");
                            timeTrialQuestions();
                        }

                        textUserAnswer.setText("");
                    }
                });
                break;

            //Mix Sub
            case 1:
                num1 = random.nextInt(100);
                num2 = random.nextInt(100);
                if (num2 > num1) {
                    temp = num1;
                    num1 = num2;
                    num2 = temp;

                }
                question.setText("What is " + num1 + "-" + num2 + "?");


                button_submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int userAnswer = Integer.parseInt(textUserAnswer.getText().toString());
                        int actualAnswer = num1 - num2;

                        if (userAnswer == actualAnswer) {
                            questions.append(num1);
                            questions.append("-");
                            questions.append(num2);
                            questions.append(" (Correct)\n");
                            correct += 1;
                            timeTrialQuestions();
                        } else {
                            questions.append(num1);
                            questions.append("-");
                            questions.append(num2);
                            questions.append(" (Wrong)\n");
                            timeTrialQuestions();
                        }

                        textUserAnswer.setText("");
                    }
                });
                break;

            //Mix Multiply
            case 2:
                num1 = random.nextInt(12);
                num2 = random.nextInt(12);
                question.setText("What is " + num1 + "x" + num2 + "?");


                button_submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int userAnswer = Integer.parseInt(textUserAnswer.getText().toString());
                        int actualAnswer = (num1 * num2);

                        if (userAnswer == actualAnswer) {
                            questions.append(num1);
                            questions.append("x");
                            questions.append(num2);
                            questions.append(" (Correct)\n");
                            correct += 1;
                            timeTrialQuestions();
                        } else {
                            questions.append(num1);
                            questions.append("x");
                            questions.append(num2);
                            questions.append(" (Wrong)\n");
                            timeTrialQuestions();
                        }

                        textUserAnswer.setText("");
                    }
                });

                break;

            //Mix Divide
            case 3:
                float num1 = random.nextInt(12);
                float num2 = random.nextInt(12);
                question.setText("What is " + num1 + "/" + num2 + "?");


                button_submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        float userAnswer = Float.parseFloat(textUserAnswer.getText().toString());
                        float actualAnswer = (num1 / num2);
                        actualAnswer = Math.round(actualAnswer * 100);
                        actualAnswer = actualAnswer / 100;


                        if (userAnswer == actualAnswer) {
                            questions.append(num1);
                            questions.append("/");
                            questions.append(num2);
                            questions.append(" (Correct)\n");
                            timeTrialQuestions();


                        } else {
                            questions.append(num1);
                            questions.append("/");
                            questions.append(num2);
                            questions.append(" (Wrong)\n");
                            timeTrialQuestions();
                        }

                        textUserAnswer.setText("");
                    }
                });
                break;


            default:
                break;
        }

        button_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonState();

            }
        });

    }

    public void timerStart(){
        countDown = new CountDownTimer(time, 1000) {
            @Override
            public void onTick(long l) {
                time = l;
                int seconds = (int) time % 60000/1000;
                timerNum.setText("Timer: " + seconds);
            }

            @Override
            public void onFinish() {
                endProgram();
            }
        }.start();
        buttonFlag = true;
        button_pause.setText("Pause");
    }

    public void timerStop(){
        countDown.cancel();
        buttonFlag = false;
        button_pause.setText("Unpause");
        Toast.makeText(this, "Game Paused", Toast.LENGTH_SHORT).show();
    }

    public void buttonState(){
        if(buttonFlag){
            timerStop();
        }
        else{
            timerStart();
            Toast.makeText(this, "Game Resumed", Toast.LENGTH_SHORT).show();
        }

    }

    public void endProgram(){
        timerNum.setVisibility(View.INVISIBLE);
        float time = (finish - start) / 1000;
        question.setText("\t GAME OVER \n\t Your Score: " + correct);
        allquestions.setText(questions.toString());
        finish = System.currentTimeMillis();
    }
}