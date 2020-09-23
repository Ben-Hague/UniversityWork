module Decode(SW, HEX0);
	// Define inputs
	input [3:0] SW;
	// Define Outputs 
	output reg [0:6] HEX0;
	
	always @(SW)	begin
	// Truth table for values 0 - 15
		case(SW)
			4'd0:HEX0 <=  7'b000_0001;
			4'd1:HEX0 <=  7'b100_1111;
			4'd2:HEX0 <=  7'b001_0010;
			4'd3:HEX0 <=  7'b000_0110;
			4'd4:HEX0 <=  7'b100_1100;
			4'd5:HEX0 <=  7'b010_0100;
			4'd6:HEX0 <=  7'b010_0000;
			4'd7:HEX0 <=  7'b000_1111;
			4'd8:HEX0 <=  7'b000_0000;
			4'd9:HEX0 <=  7'b000_0100;
			4'd10:HEX0 <= 7'b000_1000;
			4'd11:HEX0 <= 7'b110_0000;
			4'd12:HEX0 <= 7'b011_0001;
			4'd13:HEX0 <= 7'b100_0010;
			4'd14:HEX0 <= 7'b011_0000;
			4'd15:HEX0 <= 7'b011_1000;
			default:HEX0 <= 7'b1111111;
		endcase
	end
endmodule
