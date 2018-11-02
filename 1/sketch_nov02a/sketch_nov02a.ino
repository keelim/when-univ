void setup() {
  pinMode(2, INPUT);
}

void loop() {
  if(digitalRead(2) == 1){
      analogWrite(11, 50);
      
      for(int i = 0; i < 255; i++)
      {    delay(70);
          analogWrite(11, i*3);
      }
      analogWrite(11, 0);
      

  } else{
      analogWrite(11, 0);
  }
  
  
}
