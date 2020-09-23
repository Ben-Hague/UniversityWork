module BaudCounter (clk, reset_n, Baud);
	// Set Inputs, clk and reset_n
	input clk, reset_n;
	// Set Baud as a reg output
	// Must be reg to allow writing to the output
	output reg Baud;
	
	// declare 2 counts (Maximum counted to as 1302, or BaudRate/ClockPeriod)
	reg [10:0] pcount, ncount;
	// Declare the stop point for the count as a parameter, Allows it to change in BDF
	parameter maxCount = 11'd1302;
	
	// Synchronous block with asynchronous reset
	always @(posedge clk, negedge reset_n)
	if (reset_n == 0)
		pcount<=11'b0;
	else 
		pcount<=ncount;
		
	// Execute the following block at update of pcount
	always @(pcount)
	begin 
		// Set Defaults to prevent latches
		Baud = 0;
		ncount = pcount + 1'b1;
		// When finished counting, set baud high and reset the Counter to 0
		if (pcount == maxCount)
			begin
				Baud = 1;
				ncount = 11'd0;
			end
	end
endmodule
