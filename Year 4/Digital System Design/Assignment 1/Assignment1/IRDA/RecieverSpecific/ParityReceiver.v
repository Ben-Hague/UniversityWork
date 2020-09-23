module ParityReciever(Data, OutData, ParityError, FramingError);
	// No Clock and Reset in this block as it is purely combinational logic.
	
	// Input for Data (width 11)
	input [10:0] Data;
	
	//Output for Data width 6
	output [6:0] OutData;
	//output for ParityErrors and Framing errors
	output ParityError, FramingError;
	
	// Wires for start, stop and parity
	wire Parity;
	wire [2:0]StartStop;
	
	// Assign The output to the relevant data
	assign OutData[6:0] = Data[7:1];
	
	//Assign the parity
	assign Parity = Data[8];
	// Assign the concocted start and stop bits
	assign StartStop[2:0] = {Data[0], Data[10:9]};
	
	// Check if the parity bit corrosponds to data parity
	assign ParityError = ^OutData != Parity;
	//Check if the start stop bits corrospond with the expected start and stop bits
	assign FramingError = (StartStop != 3'b011);	

endmodule
