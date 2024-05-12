# 归并排序

## 整体思路：
1. 将数组左边排好序，右边排好序，再利用辅助数组完成整体排序
2. 利用递归的方式调用上述步骤

时间复杂度：O(N * logN)

额外空间复杂度：O(N)