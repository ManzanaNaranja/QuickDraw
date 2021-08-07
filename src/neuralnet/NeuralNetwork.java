package neuralnet;

public class NeuralNetwork {
	public int inodes, hnodes, onodes;
	public double lr;
	public double[][] wih, who;

    public NeuralNetwork(int inputnodes,int hiddennodes, int outputnodes,double d) {
        this.inodes = inputnodes;
        this.hnodes = hiddennodes;
        this.onodes = outputnodes;
        this.lr = d;
        this.wih = numpy.random(0.0,Math.pow(this.inodes,-0.5),this.hnodes,this.inodes);
        this.who = numpy.random(0.0,Math.pow(this.hnodes,-0.5),this.onodes,this.hnodes);
    }
    public void train(double[] input_list, double[] targets_list) {
        double[][] inputs = numpy.transpose(input_list);
        double[][] targets = numpy.transpose(targets_list);
        double[][] hidden_inputs = numpy.dot(this.wih, inputs);
        double[][] hidden_outputs = this.activation_function(hidden_inputs);
        double[][] final_inputs = numpy.dot(this.who, hidden_outputs);
        double[][] final_outputs = this.activation_function(final_inputs);
        double[][] output_errors = numpy.subtract(targets,final_outputs);
        double[][] hidden_errors = numpy.dot(numpy.transpose(this.who), output_errors);
        this.who = numpy.add(this.who,numpy.multiply(this.lr,numpy.dot(numpy.multiply(numpy.multiply(output_errors,final_outputs), numpy.subtract(1.0,final_outputs)),numpy.transpose(hidden_outputs))));
        this.wih = numpy.add(this.wih, numpy.multiply(this.lr, numpy.dot(numpy.multiply(numpy.multiply(hidden_errors, hidden_outputs), numpy.subtract(1.0, hidden_outputs)), numpy.transpose(inputs))));
        
    }
    public double[][] query(double[] inputs_list) {
        double[][] inputs = numpy.transpose(inputs_list);
        double[][] hidden_inputs = numpy.dot(this.wih, inputs);
        double[][]  hidden_outputs = this.activation_function(hidden_inputs);
        double[][]  final_inputs = numpy.dot(this.who, hidden_outputs);
        double[][] final_outputs = this.activation_function(final_inputs);
        return final_outputs;
	}
    
    private double[][] activation_function(double[][] x) {
		for(int i = 0; i < x.length; i++) {
			for(int j = 0; j < x[0].length; j++) {
				x[i][j] = this.activation_function(x[i][j]);
			}
		}
		return x;
	}
	public double activation_function(double x) {
    	return numpy.sigmoid(x);
    }
}
