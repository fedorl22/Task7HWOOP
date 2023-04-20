public class ComplexNumber {
    private double real;
    private double imaginary;
    
    public ComplexNumber(double real, double imaginary) {
    this.real = real;
    this.imaginary = imaginary;
    }
    
    public double getReal() {
    return real;
    }
    
    public void setReal(double real) {
    this.real = real;
    }
    
    public double getImaginary() {
    return imaginary;
    }
    
    public void setImaginary(double imaginary) {
    this.imaginary = imaginary;
    }
    
    public ComplexNumber add(ComplexNumber other) {
    double real = this.real + other.real;
    double imaginary = this.imaginary + other.imaginary;
    return new ComplexNumber(real, imaginary);
    }
    
    public ComplexNumber subtract(ComplexNumber other) {
    double real = this.real - other.real;
    double imaginary = this.imaginary - other.imaginary;
    return new ComplexNumber(real, imaginary);
    }
    
    public ComplexNumber multiply(ComplexNumber other) {
    double real = this.real * other.real - this.imaginary * other.imaginary;
    double imaginary = this.imaginary * other.real + this.real * other.imaginary;
    return new ComplexNumber(real, imaginary);
    }
    
    public ComplexNumber divide(ComplexNumber other) {
    double denominator = other.real * other.real + other.imaginary * other.imaginary;
    double real = (this.real * other.real + this.imaginary * other.imaginary) / denominator;
    double imaginary = (this.imaginary * other.real - this.real * other.imaginary) / denominator;
    return new ComplexNumber(real, imaginary);
    }
    
    @Override
    public String toString() {
        return "(" + real + "+" + imaginary + "i)";
    }
    
    }