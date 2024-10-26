package uk.ac.rhul.cs2800;

public class Module {
  private String code;
  private String name;
  private boolean mnc; // mandatory non-condonable

  // Constructors
  public Module(String code, String name, boolean mnc) {
    code = code;
    name = name;
    mnc = mnc;
  }
}