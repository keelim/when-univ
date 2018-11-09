int trigPin = 12;
int echoPin = 11;
long duration;
float cm;
void setup()
{
  Serial.begin(9600);
  pinMode(trigPin, OUTPUT);
  pinMode(echoPin, INPUT);
}
void loop()
{
  digitalWrite(trigPin, LOW);
  delayMicroseconds(5);
  digitalWrite(trigPin, HIGH);
  delayMicroseconds(10);
  digitalWrite(trigPin, LOW);
  duration = pulseIn(echoPin, HIGH);
  cm = (duration / 2) / 29.1;
  Serial.print(cm);
  Serial.println("cm");
  delay(250);

  if(cm  > 80){
      analogWrite(6, 150);
      analogWrite(9, 150);
  } else{
    analogWrite(6, 0);
    analogWrite(9, 0);
  }
}