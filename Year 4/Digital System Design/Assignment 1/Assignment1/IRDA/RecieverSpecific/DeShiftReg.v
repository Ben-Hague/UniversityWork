module DeShiftReg(Data, Shift, RxD, clk, reset_n);
	// Input for Clock and Reset, Always Needed
	input clk, reset_n;
	// Input for RxD, and Shift
	input RxD;
	input Shift;
	// reg to hold Present and Next Value for cycled Data
	reg [10:0] p_val, n_val;
	//Reg to hold the currently outputted data
	output reg [10:0] Data;
	// Define the default value
	parameter defVal = 11'b01111111111;
	// Synchronous Block, on clock and reset update val or reset it 
	always @ (posedge clk, negedge reset_n)
		if (reset_n == 0) 
			p_val <= defVal;
		else p_val <= n_val;
	// functional block, on shift update the contens of n_val
	always @ (Shift)
		begin
		//Defaults to prevent latch synthsis
			n_val = p_val;
			Data = p_val;	
			// functional if statement.
			if (Shift == 1)
				n_val = {RxD, p_val[10:1]};
		end
endmodule
