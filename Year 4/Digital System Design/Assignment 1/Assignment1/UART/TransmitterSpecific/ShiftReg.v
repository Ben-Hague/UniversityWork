module ShiftReg(Data, Load, Shift, TxD, clk, reset_n);
	// Input for Clock and Reset, Always Needed
	input clk, reset_n;
	// Input for Data (width 11), Load and Shift
	input [10:0] Data;
	input Load, Shift;
	//Define the output TxD as reg to enable writing to it
	output reg TxD;
	
	// reg to hold Present and Next Value for cycled Data
	reg [10:0] p_val = defVal, n_val;
	
	// Define Default value as parameter
	parameter defVal = 11'b11111111111;
	
	// Synchronous block with asynchronous reset
	always @ (posedge clk, negedge reset_n)
		if (reset_n == 0) 
			p_val <= defVal;
		else p_val <= n_val;

	// Always block executes on Load and Shift
	always @ (Load, Shift)
		begin
			//Set Defaults to prevent Latches
			n_val = p_val;
			TxD = p_val[0];
			//if loading Update the local data store
			if (Load) 
				n_val = Data;
			else if (Shift == 1)
				// if shift is high, shift the data
				n_val = {1'b1, p_val[10:1] };
		end
endmodule