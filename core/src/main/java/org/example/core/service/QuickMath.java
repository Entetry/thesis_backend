package org.example.core.service;


import org.example.core.dto.HeightMeasureDto;
import org.example.core.dto.PerechetDto;
import org.example.core.dto.PorodaDto;
import org.example.core.dto.TrialPlotDto;
import org.example.core.entity.Perechet;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class QuickMath {
    public Double calculateCrossSectionalArea(double d){
        return Math.PI*d/4;
    }
    public Double calculateSummPlSech(TrialPlotDto trialPlotDto){
        double summPlSech=0.0;
        for (PorodaDto porodaDto: trialPlotDto.getPorodaList()) {
            for (PerechetDto perechetDto : porodaDto.getPerechetList()) {
                summPlSech += perechetDto.getStupen() * 100 * Math.PI * perechetDto.getDelovyh() * perechetDto.getDrovyanyh() / 4;
            }
        }
        return summPlSech;
    }
    public Double calculateAverageHeighAndStupenHeight(List<HeightMeasureDto>  heightMeasureDtoList, List<PerechetDto> perechets){
        double x = 0, y = 0, x2 = 0, xy = 0, x3 = 0, x4 = 0, x2y = 0, maxx = 0;
        for (HeightMeasureDto heightMeasureDto:
             heightMeasureDtoList) {
            if(heightMeasureDto.getDiameter()>maxx){
                maxx=heightMeasureDto.getDiameter();
            }
            x+=heightMeasureDto.getDiameter();
            y+=heightMeasureDto.getHeight();
            x2+=Math.pow(heightMeasureDto.getDiameter(),2);
            xy+=heightMeasureDto.getHeight()*heightMeasureDto.getDiameter();
            x3+=Math.pow(heightMeasureDto.getDiameter(),3);
            x4+=Math.pow(heightMeasureDto.getDiameter(),4);
            x2y+=Math.pow(heightMeasureDto.getDiameter(),2)*heightMeasureDto.getHeight();
        }
        double[][] mat = new double[3][3];
        mat[0][0]=x4;
        mat[0][1]=x3;
        mat[0][2]=x2;
        mat[1][0]=x3;
        mat[1][1]=x2;
        mat[1][2]=x;
        mat[2][0]=x2;
        mat[2][1]=x;
        mat[2][2]=heightMeasureDtoList.size();
       double[][] mat2 = new double[3][1];
        mat2[0][0] = x2y;
        mat2[1][0]=xy;
        mat2[2][2]=y;
       double[][] m4 = inverse(mat);
       double[][] mat3= new double[3][1];
       mat3= multiply(m4,mat2);
       double averageHeight=0.0;
        for (HeightMeasureDto heightMeasureDto: heightMeasureDtoList){
            heightMeasureDto.setDependentHeight(mat3[0][0]*Math.pow(heightMeasureDto.getDiameter(),2)+mat3[1][0]*heightMeasureDto.getHeight()+mat3[2][0]);
            averageHeight+=heightMeasureDto.getDependentHeight()/heightMeasureDtoList.size();
        }

       return averageHeight;
    }
//    public double CalculateZapas(List<PerechetDto> perechetDtos,List<HeightMeasureDto> heightMeasureDtos) {
//        double averageVolume = 0.0;
//        double a1 = 0.0;
//        double averageZapas = 0.0;
//        for (PerechetDto perechetDto :
//                perechetDtos) {
//
//            switch (perechetDto.getPoroda().getPoroda()) {
//                case ("Береза"):
//                    a1 = 0.697597;
//                    break;
//                case ("Сосна"):
//                    a1 = 0.734917;
//                    break;
//                case ("Ель"):
//                    a1 = 0.637832;
//                    break;
//                case ("Ольха черная"):
//                    a1 = 0.724094;
//                    break;
//                case ("Осина"):
//                    a1 = 0.610513;
//                    break;
//                case ("Дуб"):
//                    a1 = 0.661662;
//                    break;
//                default:
//                    a1 = 0.0;
//                    break;
//            }
//
//            averageZapas += 0.0000785398163 * Math.pow(perechetDto.getStupen(), 2) * Math.pow(stupenHeight, (2 * a1 + 1)) / ((2 * a1 + 1) * Math.pow((stupenHeight - 1.3), (2 * a1)));
//            previusStupen = currentStupen;
//        }
//
//    return averageZapas;
//    }




    private   double determinant(double[][] matrix) {
        if (matrix.length != matrix[0].length)
            throw new IllegalStateException("invalid dimensions");

        if (matrix.length == 2)
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];

        double det = 0;
        for (int i = 0; i < matrix[0].length; i++)
            det += Math.pow(-1, i) * matrix[0][i]
                    * determinant(minor(matrix, 0, i));
        return det;
    }

    private  double[][] inverse(double[][] matrix) {
        double[][] inverse = new double[matrix.length][matrix.length];

        // minors and cofactors
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                inverse[i][j] = Math.pow(-1, i + j)
                        * determinant(minor(matrix, i, j));

        // adjugate and determinant
        double det = 1.0 / determinant(matrix);
        for (int i = 0; i < inverse.length; i++) {
            for (int j = 0; j <= i; j++) {
                double temp = inverse[i][j];
                inverse[i][j] = inverse[j][i] * det;
                inverse[j][i] = temp * det;
            }
        }

        return inverse;
    }

    private  double[][] minor(double[][] matrix, int row, int column) {
        double[][] minor = new double[matrix.length - 1][matrix.length - 1];

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; i != row && j < matrix[i].length; j++)
                if (j != column)
                    minor[i < row ? i : i - 1][j < column ? j : j - 1] = matrix[i][j];
        return minor;
    }

    private  double[][] multiply(double[][] a, double[][] b) {
        if (a[0].length != b.length)
            throw new IllegalStateException("invalid dimensions");

        double[][] matrix = new double[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                double sum = 0;
                for (int k = 0; k < a[i].length; k++)
                    sum += a[i][k] * b[k][j];
                matrix[i][j] = sum;
            }
        }

        return matrix;
    }

    private  double[][] rref(double[][] matrix) {
        double[][] rref = new double[matrix.length][];
        for (int i = 0; i < matrix.length; i++)
            rref[i] = Arrays.copyOf(matrix[i], matrix[i].length);

        int r = 0;
        for (int c = 0; c < rref[0].length && r < rref.length; c++) {
            int j = r;
            for (int i = r + 1; i < rref.length; i++)
                if (Math.abs(rref[i][c]) > Math.abs(rref[j][c]))
                    j = i;
            if (Math.abs(rref[j][c]) < 0.00001)
                continue;

            double[] temp = rref[j];
            rref[j] = rref[r];
            rref[r] = temp;

            double s = 1.0 / rref[r][c];
            for (j = 0; j < rref[0].length; j++)
                rref[r][j] *= s;
            for (int i = 0; i < rref.length; i++) {
                if (i != r) {
                    double t = rref[i][c];
                    for (j = 0; j < rref[0].length; j++)
                        rref[i][j] -= t * rref[r][j];
                }
            }
            r++;
        }

        return rref;
    }

    private   double[][] transpose(double[][] matrix) {
        double[][] transpose = new double[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                transpose[j][i] = matrix[i][j];
        return transpose;
    }
}
