module BitCounter (inc, clk, reset_n, B_Done);
	// Set Inputs, clk and reset_n
	input  clk, reset_n;
	// set inc as seperate input
	input inc;
	// Set B_Done as a reg output
	// Must be reg to allow writing to the output
	output reg B_Done;
	
	// declare 2 counts (Maximum counted to as 10, or start + stop + data + parity)
	reg [3:0] pcount, ncount;
	// Declare the stop point for the count as a parameter, Allows it to change in BDF
	parameter maxCount = 4'b1010;
	
	// Synchronous block with asynchronous reset
	always @(posedge clk, negedge reset_n)
	if (reset_n == 0)
		pcount<=4'b0000;
	else 
		pcount<=ncount;
	
	// Execute the following block at update of inc and pcount.
	always @(pcount,inc)
	begin 
		// Set Defaults to prevent latches
		B_Done = 0;
		ncount = pcount;
		// When inc is high, increment counter 
		if (inc)
			begin
				ncount = pcount + 1'b1;
			end
		// When finished counting, set B_Done high 
		if (pcount == maxCount)
			begin
				B_Done = 1;
			end
	end
endmodule
