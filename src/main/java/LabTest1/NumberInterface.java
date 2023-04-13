package LabTest1;

interface NumberInterface<T>
// TODO (this signature is incomplete, and your Task 1(i) code start here)
{
    // Metadata
    // TODO
    
    // Conversions
    public T fromInteger(int value);
    public Integer toInteger();

    // Operations
    // TODO
    T add(T o);
    T mul(T o);
}

// Object for running integer operations on CPU
class CpuInt<T> implements NumberInterface<CpuInt>
    // TODO (this signature is incomplete, and your Task 1(ii) code start here)
{
    int value;
    // Constructors
    // TODO
    public CpuInt(int value) {
        this.value = value;
    }
    public CpuInt() {}

    // Metadata
@Override
    public String toString() {
        return String.format("%s[%d]" , getDevice(), this.value);
    }
    public String getDevice() {
        return "CPU";
    }

    // Conversions
    // TODO
    public CpuInt fromInteger(int value) {
        return new CpuInt(value);
    }
    public Integer toInteger() {
        return this.value;
    }

    // Operations
    public CpuInt add(CpuInt o) {
        System.out.printf("CPU Debug: %d + %d = %d\n", this.value, o.value, this.value + o.value);
        return new CpuInt(this.value + o.value);
    }
    public CpuInt mul(CpuInt o) {
        System.out.printf("CPU Debug: %d * %d = %d\n", this.value, o.value, this.value * o.value);
        return new CpuInt(this.value * o.value);
    }
}

// Object for running integer operations on GPU
class GpuInt implements NumberInterface<GpuInt>
// TODO (this signature is incomplete, and your Task 1(ii) code start here)
{
    int value;
    // Constructors
    // TODO
    public GpuInt(int value) {
        this.value = value;
    }
    public GpuInt() {}

    // Metadata
    @Override
    public String toString() {
        return String.format("%s[%d]" , getDevice(), this.value);
    }
    public String getDevice() {
        return "GPU";
    }

    // Conversions
    // TODO
    public GpuInt fromInteger(int value) {
        return new GpuInt(value);
    }
    public Integer toInteger() {
        return this.value;
    }
            
    // Operations
    public GpuInt add(GpuInt o) {
        System.out.printf("GPU Debug: %d + %d = %d\n", this.value, o.value, this.value + o.value);
        return new GpuInt(this.value + o.value);
    }
    public GpuInt mul(GpuInt o) {
        System.out.printf("GPU Debug: %d * %d = %d\n", this.value, o.value, this.value * o.value);
        return new GpuInt(this.value * o.value);
    }
}
