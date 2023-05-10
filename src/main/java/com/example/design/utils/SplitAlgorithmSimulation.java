package com.example.design.utils;

public class SplitAlgorithmSimulation {

    public static void main(String[] args) {

        // 设置初始个体数量
        int numOfIndividuals = 10;

        // 初始化个体数组，所有个体具有相同属性
        Individual[] individuals = new Individual[numOfIndividuals];
        for (int i = 0; i < individuals.length; i++) {
            individuals[i] = new Individual(0, 0);
        }

        // 模拟分裂过程，循环100次
        for (int i = 1; i <= 10000000; i++) {
            System.out.println("Round " + i + ": " + individuals.length + " individuals");

            // 计算当前所有个体的平均属性值
            double avgX = 0, avgY = 0;
            for (Individual individual : individuals) {
                avgX += individual.getX();
                avgY += individual.getY();
            }
            avgX /= individuals.length;
            avgY /= individuals.length;
            System.out.println("Average Property Value: (" + avgX + ", " + avgY + ")");

            // 判断是否需要分裂
            boolean shouldSplit = checkIfShouldSplit(individuals, avgX, avgY);

            // 如果需要分裂，则生成新个体并添加到个体数组中
            if (shouldSplit) {
                Individual[] newIndividuals = generateNewIndividuals(individuals);
                individuals = mergeIndividuals(individuals, newIndividuals);
                System.out.println("Split into " + individuals.length + " individuals");
            }
        }

    }

    /**
     * 判断当前所有个体是否需要分裂
     * @param individuals 所有个体
     * @param avgX 平均属性x值
     * @param avgY 平均属性y值
     * @return 需要分裂返回true，不需要分裂返回false
     */
    private static boolean checkIfShouldSplit(Individual[] individuals, double avgX, double avgY) {

        double maxDistance = 0;
        for (Individual individual : individuals) {
            double distance = Math.sqrt((individual.getX() - avgX) * (individual.getX() - avgX)
                    + (individual.getY() - avgY) * (individual.getY() - avgY));
            if (distance > maxDistance) {
                maxDistance = distance;
            }
        }

        if (maxDistance > 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 生成新个体
     * @param individuals 所有个体
     * @return 新个体数组
     */
    private static Individual[] generateNewIndividuals(Individual[] individuals) {

        // 生成两个新个体
        Individual individual1 = new Individual(Math.random() * 2 - 1, Math.random() * 2 - 1);
        Individual individual2 = new Individual(Math.random() * 2 - 1, Math.random() * 2 - 1);

        // 计算新个体的属性值
        double avgX = 0, avgY = 0;
        for (Individual individual : individuals) {
            avgX += individual.getX();
            avgY += individual.getY();
        }
        avgX /= individuals.length;
        avgY /= individuals.length;

        // 根据距离与平均值的关系来分配属性值给新个体
        if (Math.abs(individual1.getX() - avgX) < Math.abs(individual2.getX() - avgX)) {
            individual1.setX(avgX + (avgX - individual1.getX()));
        } else {
            individual2.setX(avgX + (avgX - individual2.getX()));
        }
        if (Math.abs(individual1.getY() - avgY) < Math.abs(individual2.getY() - avgY)) {
            individual1.setY(avgY + (avgY - individual1.getY()));
        } else {
            individual2.setY(avgY + (avgY - individual2.getY()));
        }

        // 将新个体添加进数组中
        Individual[] newIndividuals = new Individual[2];
        newIndividuals[0] = individual1;
        newIndividuals[1] = individual2;
        return newIndividuals;
    }

    /**
     * 将两个个体数组合并到一个个体数组中
     * @param individuals1 个体数组1
     * @param individuals2 个体数组2
     * @return 合并后的个体数组
     */
    private static Individual[] mergeIndividuals(Individual[] individuals1, Individual[] individuals2) {
        Individual[] mergedIndividuals = new Individual[individuals1.length + individuals2.length];
        System.arraycopy(individuals1, 0, mergedIndividuals, 0, individuals1.length);
        System.arraycopy(individuals2, 0, mergedIndividuals, individuals1.length, individuals2.length);
        return mergedIndividuals;
    }

}

/**
 * 个体类，具有x和y两个属性
 */
class Individual {

    private double x;
    private double y;

    public Individual(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}