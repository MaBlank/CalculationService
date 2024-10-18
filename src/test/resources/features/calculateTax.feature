Feature: Berechnung der Steuer

  Szenario: Berechnung der Steuer für einen gegebenen Steuerbilanzgewinn
  Angenommen, ich habe einen Steuerbilanzgewinn von 1000
  Wenn ich die calculateTaxPost-Methode aufrufe
  Dann erhalte ich eine Antwort mit dem Ergebnis 300.0
