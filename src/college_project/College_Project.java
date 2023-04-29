package college_project;

import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class College_Project
{

	public static void main(String[] args) 
	{
		int Selection;
		//Student data initialized
		int StudentID[]=new int[100];
		String StudentFname[]=new String[100];
		String StudentLname[]=new String[100];
		int StudentAge[]=new int[100];
		String StudentGender[]=new String[100];
		int StudentYear[]=new int[100];
		
		//Course data initialized
		String CourseNumber[]=new String[100];
		String CourseName[]=new String[100];
		String ProfessorName[]=new String[100];
		
		//Registration data initialized
		int RegisterStudentNumber[]=new int[100];
		String RegisterCourseNumber[]=new String[100];
		
		
		int scount=-1;
		int ccount=-1;
		int rcount=-1;
			
		scount=Begin_read_student(StudentID,StudentFname,StudentLname,StudentAge, StudentGender,StudentYear, scount);
		ccount=Begin_read_course(CourseNumber, CourseName, ProfessorName,ccount);
		rcount=Begin_read_register(RegisterStudentNumber, RegisterCourseNumber, rcount);
		
		//Perform loop until user selects option 5
		Selection=Menu();
		while(Selection != 5)
		{
			if(Selection==1)
				Modify_student(StudentID,StudentFname,StudentLname,StudentAge,StudentGender,StudentYear,scount);
			else
				if(Selection==2)
					Modify_course(CourseNumber, CourseName, ProfessorName,ccount);
				else
					if(Selection==3)
						Modify_registration(RegisterStudentNumber, RegisterCourseNumber, rcount);
					else
				    	if(Selection==4)
							Report(StudentID,StudentFname,StudentLname,StudentAge,StudentGender,StudentYear,scount,
								   CourseNumber, CourseName, ProfessorName,ccount,
								   RegisterStudentNumber, RegisterCourseNumber, rcount);
			Selection=Menu();
		}
		
		Exit_RMU(StudentID,StudentFname,StudentLname,StudentAge,StudentGender,StudentYear,scount,
				   CourseNumber, CourseName, ProfessorName,ccount,
				   RegisterStudentNumber, RegisterCourseNumber, rcount);
		
		System.exit(0);
	}
	
	public static Integer Menu()
	{
		int Selection;
		String Selection_String;
		Selection_String=JOptionPane.showInputDialog(null,"Robert Morris University"+"\n"+"\n"+"1. Add/Modify Student Information"+
				"\n"+"2. Add/Modify Course Information"+
				"\n"+"3. Add/Modify Registration"+"\n"
				+"4. Report Section"+"\n"+
				"5. Exit the System"+"\n"+"\n"+"Please Make your Selection", "Robert Morris University", JOptionPane.QUESTION_MESSAGE);
		Selection=Integer.parseInt(Selection_String);
		return Selection;
	}
	
	public static Integer Modify_student(int StudentID[],String StudentFname[],String StudentLname[],
			int StudentAge[],String StudentGender[],int StudentYear[],int scount)
	{
		int Selection;
		int student_delete_value,position=0,i;
		int student_mod_value,student_change_it;
		String Selection_String, value, student_name, student_age, student_year, output = "Robert Morris University"+"\n"+"\n"
				+"1. Add Student"+
				"\n"+"2. Modify Student"+
				"\n"+"3. Delete Student"+"\n"+
				"4. Exit Student Menu"+"\n"+"\n"+"Please Make your Selection";
		Selection_String=JOptionPane.showInputDialog(null,output, "Robert Morris University", JOptionPane.QUESTION_MESSAGE);
		Selection=Integer.parseInt(Selection_String);
		while (Selection !=4) 
		{
			if(Selection==1) 
			{
				scount=scount+1;
				
				output="Enter the Student ID";
				student_name  =JOptionPane.showInputDialog(null,
				output," ",JOptionPane.QUESTION_MESSAGE);
			    StudentID[scount]=Integer.parseInt(student_name);
			    
			    output= "Enter Student First Name";
			    StudentFname[scount]  =JOptionPane.showInputDialog(null,
			    output," ",JOptionPane.QUESTION_MESSAGE);
			    
			    output= "Enter Student Last Name";
			    StudentLname[scount]  =JOptionPane.showInputDialog(null,
			    output," ",JOptionPane.QUESTION_MESSAGE);
			    
			    output="Enter Student Age";
			    student_age  =JOptionPane.showInputDialog(null,
			    output," ",JOptionPane.QUESTION_MESSAGE);
			    StudentAge[scount]=Integer.parseInt(student_age);
			    
			    output= "Enter Student Gender (Male/Female)";
			    StudentGender[scount]  =JOptionPane.showInputDialog(null,
			    output," ",JOptionPane.QUESTION_MESSAGE);
			    
			    output="Enter Student Year";
			    student_year  =JOptionPane.showInputDialog(null,
			    output," ",JOptionPane.QUESTION_MESSAGE);
			    StudentYear[scount]=Integer.parseInt(student_year);
			}
			else
			    if (Selection ==2)
				  {
			    output= " Enter the Student ID to Modify ";
			    value  =JOptionPane.showInputDialog(null,
			    output," ",JOptionPane.QUESTION_MESSAGE);
			    student_mod_value=Integer.parseInt(value); 
			    
			    //find the position of the number to modify
			    for (i=0; i<=scount; ++i)
			      {
			        if(StudentID[i]==student_mod_value) 
			        	position = i;
			      }
			       //modify the proper data
			       output="1. Change the Student First Name "+"\n"+
			              "2. Change the Student Last Name "+"\n"+
			              "3. Change the Student Age "+"\n"+
			              "4. Change the Student Gender "+"\n"+
			              "5. Change the Student Year "+"\n"+
			               "Enter Your Selection ";
			       value  =JOptionPane.showInputDialog(null,
			       output," ",JOptionPane.QUESTION_MESSAGE);
			       student_change_it=Integer.parseInt(value);
			       if(student_change_it ==1)
			           {
			             //read new last name	
				        output= "Enter the NEW Student First Name";
				        StudentFname[position]  =JOptionPane.showInputDialog(null,
			   		    output," ",JOptionPane.QUESTION_MESSAGE);
			            }
			       else
				    	  if(student_change_it ==2)
				    	  	{
				    		  //read new last name
				    		  output="Enter the NEW Student Last Name";
				    		  StudentLname[position]  =JOptionPane.showInputDialog(null,
							   		    output," ",JOptionPane.QUESTION_MESSAGE);
				    	  	}
			      else
			    	  if(student_change_it ==3)
			    	  	{
			    		  //read new age
			    		  output="Enter the NEW Student Age";
			    		  value  =JOptionPane.showInputDialog(null,
			    				  output," ",JOptionPane.QUESTION_MESSAGE);
			    		  StudentAge[position]=Integer.parseInt(value);
			    	  	}
			    	  else
				    	  if(student_change_it ==4)
				    	  	{
				    		  //read new gender
				    		  output= "Enter the NEW Student Gender";
						        StudentGender[position]  =JOptionPane.showInputDialog(null,
					   		    output," ",JOptionPane.QUESTION_MESSAGE);
				    	  	}
				    	  else
					    	  if(student_change_it==5)
					    	  	{
					    		  //read new year
					    		  output="Enter the NEW Student Year";
					    		  value  =JOptionPane.showInputDialog(null,
					    				  output," ",JOptionPane.QUESTION_MESSAGE);
					    		  StudentYear[position]=Integer.parseInt(value);
					    	  	}
				  }//end of select=2
			if(Selection==3)
			  {
			   output= " Enter the Student ID to delete ";
			   value  =JOptionPane.showInputDialog(null,
			   output," ",JOptionPane.QUESTION_MESSAGE);
			   student_delete_value=Integer.parseInt(value);
			   //find the position of the number to delete
			   for (i=0; i<=scount; ++i)
			     {
			      if(StudentID[i]==student_delete_value) 
			    	  position = i;
			      }
			   //delete from the arrays
			   for(i=position;i<=scount-1;++i)
			   {
				   StudentID[i]=StudentID[i+1];
				   StudentFname[i]=StudentFname[i+1];
				   StudentLname[i]=StudentLname[i+1];
				   StudentAge[i]=StudentAge[i+1];
				   StudentGender[i]=StudentGender[i+1];
				   StudentYear[i]=StudentYear[i+1];
			   }
			   scount=scount-1;
			}//end of select=3
			output = "Robert Morris University"+"\n"+"\n"
					+"1. Add Student"+
					"\n"+"2. Modify Student"+
					"\n"+"3. Delete Student"+"\n"+
					"4. Exit Student Menu"+"\n"+"\n"+"Please Make your Selection";
			Selection_String=JOptionPane.showInputDialog(null,output, "Robert Morris University", JOptionPane.QUESTION_MESSAGE);
			Selection=Integer.parseInt(Selection_String);
		}//end of while loop
		return scount;
	}
	
	public static Integer Modify_course(String CourseNumber[], String CourseName[], String ProfessorName[], int ccount)
	{
		int Selection;
		int position=0,i;
		int changeit;
		String Selection_String, value, output = "Robert Morris University"+"\n"+"\n"
				+"1. Add Course"+
				"\n"+"2. Modify Course"+
				"\n"+"3. Delete Course"+"\n"+
				"4. Exit Course Menu"+"\n"+"\n"+"Please Make your Selection";
		Selection_String=JOptionPane.showInputDialog(null,output, "Robert Morris University", JOptionPane.QUESTION_MESSAGE);
		Selection=Integer.parseInt(Selection_String);
		while (Selection !=4) 
		{
			if(Selection ==1) 
			{
				ccount=ccount+1;
				output= "Enter Course Number (DEPT####)";
				CourseNumber[ccount]  =JOptionPane.showInputDialog(null,
			    output," ",JOptionPane.QUESTION_MESSAGE);
			    output= "Enter Course Name";
			    CourseName[ccount]  =JOptionPane.showInputDialog(null,
			    output," ",JOptionPane.QUESTION_MESSAGE);
			    output= "Enter Professor Name";
			    ProfessorName[ccount]  =JOptionPane.showInputDialog(null,
			    output," ",JOptionPane.QUESTION_MESSAGE);
			}
			else
			    if (Selection ==2)
				  {
			    output= "Enter the Course Number (DEPT####) to Modify ";
			    value  =JOptionPane.showInputDialog(null,
			    output," ",JOptionPane.QUESTION_MESSAGE);
			    //find the position of the number to modify
			    for (i=0; i<=ccount; ++i)
			      {
			        if(CourseNumber[i].equals(value)) position = i;
			      }
			       //modify the proper data
			       output="1. Change the Course Number (DEPT####) "+"\n"+
			              "2. Change the Course Name "+"\n"+
			              "3. Change the Course Professor "+"\n"+
			               "Enter Your Selection ";
			       value  =JOptionPane.showInputDialog(null,
			       output," ",JOptionPane.QUESTION_MESSAGE);
				   changeit=Integer.parseInt(value);
			       if(changeit ==1)
			           {
			             //read new last name	
				        output= "Enter the NEW Course Number (DEPT####)";
				        CourseNumber[position]  =JOptionPane.showInputDialog(null,
			   		    output," ",JOptionPane.QUESTION_MESSAGE);
			            }
			       else
				    	  if(changeit ==2)
				    	  	{
				    		  //read new last name
				    		  output="Enter the NEW Course Name";
				    		  CourseName[position]  =JOptionPane.showInputDialog(null,
							   		    output," ",JOptionPane.QUESTION_MESSAGE);
				    	  	}
			      else
			    	  if(changeit ==3)
			    	  	{
			    		  //read new age
			    		  output="Enter the NEW Course Professor";
			    		  value  =JOptionPane.showInputDialog(null,
			    				  output," ",JOptionPane.QUESTION_MESSAGE);
			    		  ProfessorName[position]=JOptionPane.showInputDialog(null,
						   		    output," ",JOptionPane.QUESTION_MESSAGE);
			    	  	}
			    	  
				  }//end of select=2
			if(Selection==3)
			  {
			   output= " Enter the Course Number (DEPT####) to Delete ";
			   value  =JOptionPane.showInputDialog(null,
			   output," ",JOptionPane.QUESTION_MESSAGE);
			   //find the position of the number to delete
			   for (i=0; i<=ccount; ++i)
			     {
			      if(CourseNumber[i].equals(value)) position = i;
			      }
			   //delete from the arrays
			   for(i=position;i<=ccount-1;++i)
			   {
				   CourseNumber[i]=CourseNumber[i+1];
				   CourseName[i]=CourseName[i+1];
				   ProfessorName[i]=ProfessorName[i+1];
			   }
			   ccount=ccount-1;
			}//end of select=3
			output = "Robert Morris University"+"\n"+"\n"
					+"1. Add Course"+
					"\n"+"2. Modify Course"+
					"\n"+"3. Delete Course"+"\n"+
					"4. Exit Course Menu"+"\n"+"\n"+"Please Make your Selection";
			Selection_String=JOptionPane.showInputDialog(null,output, "Robert Morris University", JOptionPane.QUESTION_MESSAGE);
			Selection=Integer.parseInt(Selection_String);
		}//end of while loop
		return ccount;
	}
	
	public static Integer Modify_registration(int RegisterStudentNumber[], String RegisterCourseNumber[],int rcount)
	{
		int Selection;
		int changestudentid,changeit,delete_value,position=0,i;
		String Selection_String,value,output = "Robert Morris University"+"\n"+"\n"
				+"1. Add Registration"+
				"\n"+"2. Modify Registration"+
				"\n"+"3. Delete Registration"+"\n"+
				"4. Exit Registration Menu"+"\n"+"\n"+"Please Make your Selection";
		Selection_String=JOptionPane.showInputDialog(null,output, "Robert Morris University", JOptionPane.QUESTION_MESSAGE);
		Selection=Integer.parseInt(Selection_String);
			while (Selection !=4) 
			{
				if(Selection ==1) 
				{
					rcount=rcount+1;
					
					output="Enter the Student ID";
					value  =JOptionPane.showInputDialog(null,
					output," ",JOptionPane.QUESTION_MESSAGE);
					RegisterStudentNumber[rcount]=Integer.parseInt(value);
				    output= "Enter Course Number (DEPT####)";
				    
				    RegisterCourseNumber[rcount]  =JOptionPane.showInputDialog(null,
				    output," ",JOptionPane.QUESTION_MESSAGE);
				}
				else
				    if (Selection ==2)
					  {
				    output= " Enter the Registration to Modify ";
				    value  =JOptionPane.showInputDialog(null,
				    output," ",JOptionPane.QUESTION_MESSAGE);
				    changestudentid=Integer.parseInt(value);
				    //find the position of the number to modify
				    for (i=0; i<=rcount; ++i)
				      {
				        if(RegisterStudentNumber[i] ==changestudentid) position = i;
				      }
				       //modify the proper data
				       output="1. Change the Student ID "+"\n"+
				              "2. Change the Course Number (DEPT####) "+"\n"+
				               "Enter Your Selection ";
				       value  =JOptionPane.showInputDialog(null,
				       output," ",JOptionPane.QUESTION_MESSAGE);
					   changeit=Integer.parseInt(value);
				       if(changeit ==1)
				           {
				             //read new last name	
					        output= "Enter the NEW Student ID";
					        value =JOptionPane.showInputDialog(null,
						   		    output," ",JOptionPane.QUESTION_MESSAGE);
					        RegisterStudentNumber[position]  =Integer.parseInt(value);
				            }
				       else
					    	  if(changeit ==2)
					    	  	{
					    		  //read new last name
					    		  output="Enter the NEW Course Number (DEPT####)";
					    		  RegisterCourseNumber[position]  =JOptionPane.showInputDialog(null,
								   		    output," ",JOptionPane.QUESTION_MESSAGE);
					    	  	}

				    	  
					  }//end of select=2
				if(Selection==3)
				  {
				   output= " Enter the Student ID to Delete ";
				   value  =JOptionPane.showInputDialog(null,
				   output," ",JOptionPane.QUESTION_MESSAGE);
				   delete_value=Integer.parseInt(value);
				   //find the position of the number to delete
				   for (i=0; i<=rcount; ++i)
				     {
				      if(RegisterStudentNumber[i] ==delete_value) position = i;
				      }
				   //delete from the arrays
				   for(i=position;i<=rcount-1;++i)
				   {
					   RegisterStudentNumber[i]=RegisterStudentNumber[i+1];
					   RegisterCourseNumber[i]=RegisterCourseNumber[i+1];
				   }
				   rcount=rcount-1;
				}//end of select=3
				output = "Robert Morris University"+"\n"+"\n"
						+"1. Add Registration"+
						"\n"+"2. Modify Registration"+
						"\n"+"3. Delete Registration"+"\n"+
						"4. Exit Course Menu"+"\n"+"\n"+"Please Make your Selection";
				Selection_String=JOptionPane.showInputDialog(null,output, "Robert Morris University", JOptionPane.QUESTION_MESSAGE);
				Selection=Integer.parseInt(Selection_String);
		}//end of while loop
			return rcount;
	}
	
	public static void Report(int StudentID[],String StudentFname[],String StudentLname[],
			int StudentAge[],String StudentGender[],int StudentYear[],int scount, 
			String CourseNumber[], String CourseName[], String ProfessorName[], int ccount,
			int RegisterStudentNumber[], String RegisterCourseNumber[],int rcount)
	{
	    int Selection_Report = 0;
		Selection_Report=Report_Menu();
		while(Selection_Report != 11)
		{
			int i;
			if(Selection_Report==1)
			{
				System.out.println("All Students");
				System.out.println("============");
				for (i=0;i<=scount;++i)
					{
						System.out.println(StudentID[i]+" "+StudentFname[i]+" "+StudentLname[i]+" "+StudentAge[i]+" "+
							StudentGender[i]+" "+StudentYear[i]);
					}
				}
			else
			
			
				if(Selection_Report==2)
				{
					System.out.println("All Courses");
					System.out.println("============");
					for (i=0;i<=ccount;++i)
						{
							System.out.println(CourseNumber[i]+" "+CourseName[i]+" "+ProfessorName[i]);
						}
				}
				else
			
					if(Selection_Report==3)
					{
						System.out.println("All Registration");
						System.out.println("============");
						for (i=0;i<=rcount;++i)
							{
								System.out.println(RegisterStudentNumber[i]+" "+RegisterCourseNumber[i]);
							}
					}
					else
			
			
						if(Selection_Report==4)
						{
							String year=JOptionPane.showInputDialog(null,"Enter the Year to Search for (1/2/3/4)",
									"Robert Morris University", JOptionPane.QUESTION_MESSAGE);
							int search_year = Integer.parseInt(year);
							System.out.println("Student Enrollment for Year "+search_year);
							System.out.println("============");
								for(i=0; i<=scount; ++i)
									{
									if(StudentYear[i]==search_year)
										{
										System.out.println(StudentFname[i]+" "+StudentLname[i]);
										}//if statement
									}//i loop
						}	
						else
							
							if(Selection_Report==5)
							{
								String search_professor=JOptionPane.showInputDialog(null,"Enter the Professor to Search for",
										"Robert Morris University", JOptionPane.QUESTION_MESSAGE);
								System.out.println("Courses Taught by "+search_professor);
								System.out.println("============");
									for(i=0; i<=ccount; ++i)
										{
										if(ProfessorName[i].equals(search_professor))
											{
											System.out.println(CourseNumber[i]);
											}//if statement
										}//i loop
							}	
								else
								
									if(Selection_Report==6)
									{
										String student_id_report=JOptionPane.showInputDialog(null,"Enter the Student ID to Search for",
												"Robert Morris University", JOptionPane.QUESTION_MESSAGE);
										int search_student_id = Integer.parseInt(student_id_report);
										System.out.println("Courses Taken By "+search_student_id);
										System.out.println("============");
											for(i=0; i<=ccount; ++i)
												{
												if(RegisterStudentNumber[i]==search_student_id)
													{
													System.out.println(RegisterCourseNumber[i]);
													}//if statement
												}//i loop
									}	
									else
								
								
										if(Selection_Report==7)
										{
											String course_number_report=JOptionPane.showInputDialog(null,"Enter the Course Number (DEPT####) to Search for",
													"Robert Morris University", JOptionPane.QUESTION_MESSAGE);
											System.out.println("Students Enrolled in "+course_number_report);
											System.out.println("============");
					
												int students_enrolled = 0;
												for(i=0; i<=rcount; ++i)
												{
													if(RegisterCourseNumber[i].equals(course_number_report))
														{
														students_enrolled = students_enrolled+1;
														}//if statement
													}//i loop
												System.out.println(students_enrolled+" Students");
										}	
										else
								
								
											if(Selection_Report==8)
											{
												String search_student_id_report=JOptionPane.showInputDialog(null,"Enter the Student ID to Search for",
														"Robert Morris University", JOptionPane.QUESTION_MESSAGE);
												int search_student = Integer.parseInt(search_student_id_report);
													for(i=0; i<=scount; ++i)
														{
														if(StudentID[i]==search_student)
															{
															System.out.println("Course Information for "+StudentID[i]+" "+StudentFname[i]+" "+StudentLname[i]);
															System.out.println("============");
															for(int j=0;j<=rcount;++j)
																{
																if(StudentID[i]==RegisterStudentNumber[j])
																	{
																	for(int k=0;k<=ccount;++k)
																	   {
																		if(RegisterCourseNumber[j].equals(CourseNumber[k]))
																			System.out.println(CourseNumber[k]+" "+CourseName[k]+" "+ProfessorName[k]);
																	   }//end of k loop
																	}//if match between student arrays and registration arrays
																}//j loop
															}//if match in course arrays
														}//i loop
											}	
											else	
												
												if(Selection_Report==9)
												{
													String search_course=JOptionPane.showInputDialog(null,"Enter the Course Number (DEPT####) to Search for",
															"Robert Morris University", JOptionPane.QUESTION_MESSAGE);
														for(i=0; i<=ccount; ++i)
															{
															if(CourseNumber[i].equals(search_course))
																{
																System.out.println("Student Enrollment for "+CourseNumber[i]+" "+CourseName[i]+" "+ProfessorName[i]);
																System.out.println("============");
																for(int j=0;j<=rcount;++j)
																	{
																	if(CourseNumber[i].equals(RegisterCourseNumber[j]))
																		{
																		for(int k=0;k<=scount;++k)
																		   {
																			if(RegisterStudentNumber[j]==StudentID[k])
																				System.out.println(StudentFname[k]+" "+StudentLname[k]);
																		   }//end of k loop
																		}//if match between course arrays and registration arrays
																	}//j loop
																}//if match in course arrays
															}//i loop

												}	
												else	
													
													if(Selection_Report==10)
													{
															for(i=0; i<=ccount; ++i)
																{
																	System.out.println("Total Enrollment for "+CourseNumber[i]+" "+CourseName[i]+" "+ProfessorName[i]);
																	System.out.println("============");
																	for(int j=0;j<=rcount;++j)
																		{
																		if(CourseNumber[i].equals(RegisterCourseNumber[j]))
																			{
																			for(int k=0;k<=scount;++k)
																			   {
																				if(RegisterStudentNumber[j]==StudentID[k])
																					System.out.println(StudentFname[k]+" "+StudentLname[k]);
																			   }//end of k loop
																			}//if match between course arrays and registration arrays
																		}//j loop
																}//i loop
													}	
			Selection_Report=Report_Menu();
		}
		
	}
	
	public static Integer Report_Menu()
	{
		Integer Selection_Report = 0;
		String Selection_Report_String;
		
		Selection_Report_String=JOptionPane.showInputDialog(null,"Robert Morris University"+"\n"+"\n"+
		        "1. Student Master List"+"\n"+
				"2. Course Master List"+"\n"+
				"3. Registration Master List"+"\n"+
				"4. Student List by Year"+"\n"+
				"5. Professor Course List "+"\n"+
				"6. Student Course List "+"\n"+
				"7. Course Enrollment Count "+"\n"+
				"8. Detailed Student Course List "+"\n"+
				"9. Single Course Enrollment "+"\n"+
				"10.Total Course Enrollment "+"\n"+
				"11.Exit Report Menu"+"\n"+"\n"+
				"Please Make your Selection", "Robert Morris University", JOptionPane.QUESTION_MESSAGE);
		Selection_Report=Integer.parseInt(Selection_Report_String);
		return Selection_Report;
	}
	
	public static int Begin_read_student(int StudentID[],String StudentFname[],String StudentLname[],
			int StudentAge[],String StudentGender[],int StudentYear[],int scount)
	{
		//read student data file
	String newLine;
			try
			{
			 //define a file variable for Buffered read
			BufferedReader student_file = new BufferedReader(new FileReader("student.txt"));
			//read lines in file until there are no more lines in the file to read
			while ((newLine = student_file.readLine()) != null)
				         {
				           //there is a "#" between each data item in each line
				            StringTokenizer delimiter = new StringTokenizer(newLine,"#");
				            scount=scount+1;
				            StudentID[scount] =Integer.parseInt(delimiter.nextToken());
				            StudentFname[scount] =delimiter.nextToken();
				            StudentLname[scount] =delimiter.nextToken();
				            StudentAge[scount] = Integer.parseInt(delimiter.nextToken());
				            StudentGender[scount] =delimiter.nextToken();
				            StudentYear[scount] = Integer.parseInt(delimiter.nextToken());
				         }//while loop
				         student_file.close();
				      }//end try
				  catch (IOException error)
				    {
				    //there was an error on the file writing
				    System.out.println("Error on file read " + error);
				    }//error on read

		return scount;
	}
	
	public static int Begin_read_course(String CourseNumber[], String CourseName[], String ProfessorName[], int ccount)
	{
		//read course data file
		String newLine;
				try
				{
				 //define a file variable for Buffered read
				BufferedReader course_file = new BufferedReader(new FileReader("course.txt"));
				//read lines in file until there are no more lines in the file to read
				while ((newLine = course_file.readLine()) != null)
					         {
					           //there is a "#" between each data item in each line
					            StringTokenizer delimiter = new StringTokenizer(newLine,"#");
					            ccount=ccount+1;
					            CourseNumber[ccount] =delimiter.nextToken();
					            CourseName[ccount] =delimiter.nextToken();
					            ProfessorName[ccount] =delimiter.nextToken();
					         }//while loop
								course_file.close();
					      }//end try
					  catch (IOException error)
					    {
					    //there was an error on the file writing
					    System.out.println("Error on file read " + error);
					    }//error on read
			return ccount;
	}
	
	public static int Begin_read_register(int RegisterStudentNumber[], String RegisterCourseNumber[],int rcount)
	{
		//read register data file
				String newLine;
						try
						{
						 //define a file variable for Buffered read
						BufferedReader register_file = new BufferedReader(new FileReader("register.txt"));
						//read lines in file until there are no more lines in the file to read
						while ((newLine = register_file.readLine()) != null)
							         {
							           //there is a "#" between each data item in each line
							            StringTokenizer delimiter = new StringTokenizer(newLine,"#");
							            rcount=rcount+1;
							            RegisterStudentNumber[rcount] = Integer.parseInt(delimiter.nextToken());
							            RegisterCourseNumber[rcount] =delimiter.nextToken();
							         }//while loop
										register_file.close();
							      }//end try
							  catch (IOException error)
							    {
							    //there was an error on the file writing
							    System.out.println("Error on file read " + error);
							    }//error on read
					return rcount;
	}
	
	public static void Exit_RMU(int StudentID[], String StudentFname[], String StudentLname[],
            int StudentAge[], String StudentGender[], int StudentYear[], int scount,
            String CourseNumber[], String CourseName[], String ProfessorName[], int ccount,
            int RegisterStudentNumber[], String RegisterCourseNumber[], int rcount) 
	{
		try 
		{
			BufferedWriter student_file = new BufferedWriter(new FileWriter("student.txt"));
			for (int i = 0; i <= scount; i++) 
			{
				student_file.write(StudentID[i] + "#" + StudentFname[i] + "#" + StudentLname[i]
						+ "#" + StudentAge[i] + "#" + StudentGender[i] + "#" + StudentYear[i] + "#");
				
				student_file.newLine();
				}
			student_file.close();
			
			BufferedWriter course_file = new BufferedWriter(new FileWriter("course.txt"));
			for (int j = 0; j <= ccount; j++) 
			{
				course_file.write(CourseNumber[j] + "#" + CourseName[j] + "#" + ProfessorName[j]);
				course_file.newLine();
				}
			course_file.close();
			
			BufferedWriter register_file = new BufferedWriter(new FileWriter("register.txt"));
			for (int k = 0; k <= rcount; k++) 
			{
				register_file.write(RegisterStudentNumber[k] + "#" + RegisterCourseNumber[k]);
				register_file.newLine();
				}
			register_file.close();
			} 
		catch (IOException error) {
			System.out.println("Error on file write: " + error.getMessage());
			}	
	}
	
}